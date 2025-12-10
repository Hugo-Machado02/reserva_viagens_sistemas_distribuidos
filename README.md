# Sistema de Reserva de Viagens - Microsserviços Distribuídos

Sistema distribuído para reserva de viagens utilizando arquitetura de microsserviços com Spring Boot, Spring Cloud Gateway e React.

## 🏗️ Arquitetura

### Backend (Microsserviços)
- **ms_eureka** (Porta 8761) - Service Discovery (Eureka Server)
- **ms_gateway** (Porta 8080) - API Gateway (Spring Cloud Gateway)
- **ms_voos** - Gerenciamento de voos e assentos
  - Instância 1: Porta 8764
  - Instância 2: Porta 8765
- **ms_hoteis** - Gerenciamento de hotéis e quartos
  - Instância 1: Porta 8762
  - Instância 2: Porta 8763
- **ms_reservas** (Porta 8766) - Gerenciamento de reservas integrando voos e hotéis

### Frontend
- **Gateway React** (Porta 5173) - Interface web com comunicação via API Gateway

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Node.js 18+
- MySQL 8.0+
- Maven

### 1. Configurar Banco de Dados

Importe o backup do banco de dados:
```bash
mysql -u root -p < src/bkp_db/backup_db.sql
```

Este comando criará automaticamente os bancos:
- `voos_db` - com tabelas de voos e assentos
- `hoteis_db` - com tabelas de hotéis e quartos  
- `reservas_db` - com tabela de reservas

Configure o usuário e senha no arquivo:
- `src/backend/ms_reservas/src/main/resources/application.properties`

### 2. Execução Automática (Recomendado)

Execute o script que inicia todos os serviços automaticamente:
```bash
cd instancias
start_all_services.bat
```

Este script iniciará na ordem correta:
1. Eureka Server
2. API Gateway
3. MS Hotéis (2 instâncias)
4. MS Voos (2 instâncias)
5. MS Reservas
6. Frontend React

### 3. Execução Manual (Opcional)

Se preferir iniciar manualmente, execute na ordem:

#### 1. Eureka Server
```bash
cd instancias
01_start_eureka.bat
```

#### 2. API Gateway
```bash
cd instancias
02_start_gateway.bat
```

#### 3. Microsserviços (qualquer ordem)
```bash
cd instancias
03_start_hoteis_instancia1.bat
04_start_hoteis_instancia2.bat
05_start_voos_instancia1.bat
06_start_voos_instancia2.bat
07_start_reservas.bat
```

#### 4. Frontend
```bash
cd instancias
08_start_frontend.bat
```

**Verificação:** Acesse http://localhost:8761 e confirme que todos os microsserviços aparecem registrados.

## 📡 Endpoints da API

**Todas as requisições devem ser feitas através do API Gateway (porta 8080)**

### MS Voos (via Gateway)
- `GET http://localhost:8080/api/voos` - Listar todos os voos
- `GET http://localhost:8080/api/voos/{id}` - Buscar voo por ID
- `POST http://localhost:8080/api/voos` - Criar novo voo
- `PUT http://localhost:8080/api/voos/{id}` - Atualizar voo
- `DELETE http://localhost:8080/api/voos/{id}` - Deletar voo
- `POST http://localhost:8080/api/voos/{id}/reservar` - Reservar assento

### MS Hotéis (via Gateway)
- `GET http://localhost:8080/api/hoteis` - Listar todos os hotéis
- `GET http://localhost:8080/api/hoteis/{id}` - Buscar hotel por ID
- `POST http://localhost:8080/api/hoteis` - Criar novo hotel
- `PUT http://localhost:8080/api/hoteis/{id}` - Atualizar hotel
- `DELETE http://localhost:8080/api/hoteis/{id}` - Deletar hotel
- `GET http://localhost:8080/api/hoteis/{id}/quartos` - Listar quartos do hotel

### MS Reservas (via Gateway)
- `GET http://localhost:8080/api/reservas` - Listar todas as reservas
- `GET http://localhost:8080/api/reservas/{id}` - Buscar reserva por ID
- `POST http://localhost:8080/api/reservas` - Criar nova reserva
- `PATCH http://localhost:8080/api/reservas/{id}/confirmar` - Confirmar reserva
- `PATCH http://localhost:8080/api/reservas/{id}/cancelar` - Cancelar reserva
- `DELETE http://localhost:8080/api/reservas/{id}` - Deletar reserva

## 🎯 Funcionalidades

### API Gateway (Spring Cloud Gateway)
- ✅ Roteamento inteligente para múltiplas instâncias
- ✅ Load balancing automático
- ✅ Service discovery via Eureka
- ✅ Configuração CORS para frontend
- ✅ Centralização de requisições

### Frontend React
- ✅ Interface intuitiva para testar endpoints
- ✅ Comunicação via API Gateway
- ✅ Monitoramento de requisições
- ✅ Suporte a todas as operações CRUD

## 🔧 Tecnologias Utilizadas

### Backend
- Spring Boot 3.3.5
- Spring Cloud Gateway (API Gateway)
- Spring Cloud Netflix Eureka (Service Discovery)
- Spring Data JPA
- MySQL 8.0
- WebClient (para comunicação entre serviços)
- Maven

### Frontend
- React 19
- TypeScript
- Vite (com Rolldown)
- Fetch API

## 📝 Estrutura do Projeto

```
reserva_viagens_sistemas_distribuidos/
├── instancias/                    # Scripts de inicialização
│   ├── start_all_services.bat     # Inicia todos os serviços
│   ├── 01_start_eureka.bat
│   ├── 02_start_gateway.bat
│   ├── 03-06_start_*_instancia*.bat
│   ├── 07_start_reservas.bat
│   └── 08_start_frontend.bat
├── src/
│   ├── backend/
│   │   ├── ms_eureka/             # Service Discovery
│   │   ├── ms_gateway/            # API Gateway
│   │   ├── ms_voos/               # Microsserviço de Voos
│   │   ├── ms_hoteis/             # Microsserviço de Hotéis
│   │   └── ms_reservas/           # Microsserviço de Reservas
│   ├── bkp_db/                    # Backup do banco de dados
│   └── frontend/
│       └── gateway/               # Interface React
└── README.md
```

## 📊 Monitoramento e Acesso

- **Eureka Dashboard:** http://localhost:8761
- **API Gateway:** http://localhost:8080
- **MS Voos (Instância 1):** http://localhost:8764
- **MS Voos (Instância 2):** http://localhost:8765
- **MS Hotéis (Instância 1):** http://localhost:8762
- **MS Hotéis (Instância 2):** http://localhost:8763
- **MS Reservas:** http://localhost:8766
- **Frontend React:** http://localhost:5173

## ⚖️ Load Balancing

O sistema implementa load balancing através do API Gateway:
- **MS Voos:** 2 instâncias (8764, 8765)
- **MS Hotéis:** 2 instâncias (8762, 8763)
- **MS Reservas:** 1 instância (8766)

O Gateway roteia automaticamente as requisições entre as instâncias disponíveis.

## 🤝 Contribuidores

- [Arthur Renato](https://github.com/tuti70)
- [Hugo Machado](https://github.com/Hugo-Machado02)
- [Joselio Jr](https://github.com/JoselioJr)
- [Shayra Kelly](https://github.com/ShayraKelly)