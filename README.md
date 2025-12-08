# Sistema de Reserva de Viagens - Microsserviços Distribuídos

Sistema distribuído para reserva de viagens utilizando arquitetura de microsserviços com Spring Boot e React.

## 🏗️ Arquitetura

### Backend (Microsserviços)
- **ms_voos** (Porta 8081) - Gerenciamento de voos e assentos
- **ms_hoteis** (Porta 8082) - Gerenciamento de hotéis e quartos
- **ms_reservas** (Porta 8083) - Gerenciamento de reservas integrando voos e hotéis
- **ms_eureka** (Porta 8761) - Service Discovery

### Frontend
- **Gateway React** (Porta 5173) - Interface web com log de requisições em tempo real

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Node.js 18+
- MySQL 8.0+
- Maven

### 1. Configurar Banco de Dados

Crie os bancos de dados no MySQL:
```sql
CREATE DATABASE voos_db;
CREATE DATABASE ms_hoteis;
CREATE DATABASE reservas_db;
```

Configure os usuário e as senhas nos arquivos `application.properties` de cada microsserviço:
- `src/backend/ms_voos/src/main/resources/application.properties`
- `src/backend/ms_hoteis/src/main/resources/application.properties`
- `src/backend/ms_reservas/src/main/resources/application.properties`

### 2. Iniciar Microsserviços Backend

**IMPORTANTE:** Inicie os serviços na ordem abaixo:

#### 1. Eureka Server (Service Discovery)
```bash
cd src/backend/ms_eureka
mvn clean package
java -jar target/ms_eureka-0.0.1-SNAPSHOT.jar
```
Aguarde até ver a mensagem de inicialização completa.
Acesse: http://localhost:8761

#### 2. MS Voos
```bash
cd src/backend/ms_voos
mvn clean package
java -jar target/ms_voos-0.0.1-SNAPSHOT.jar
```

#### 3. MS Hotéis
```bash
cd src/backend/ms_hoteis
mvn clean package
java -jar target/ms_hoteis-0.0.1-SNAPSHOT.jar
```

#### 4. MS Reservas
```bash
cd src/backend/ms_reservas
mvn clean package
java -jar target/ms_reservas-0.0.1-SNAPSHOT.jar
```

**Verificação:** Acesse http://localhost:8761 e confirme que os 3 microsserviços aparecem registrados.

### 3. Iniciar Frontend Gateway

```bash
cd src/frontend/gateway
npm install
npm run dev
```

Acesse: http://localhost:5173

## 📡 Endpoints da API

### MS Voos (8081)
- `GET /api/voos` - Listar todos os voos
- `GET /api/voos/{id}` - Buscar voo por ID
- `POST /api/voos` - Criar novo voo
- `PUT /api/voos/{id}` - Atualizar voo
- `DELETE /api/voos/{id}` - Deletar voo

### MS Hotéis (8082)
- `GET /api/hoteis` - Listar todos os hotéis
- `GET /api/hoteis/{id}` - Buscar hotel por ID
- `POST /api/hoteis` - Criar novo hotel
- `PUT /api/hoteis/{id}` - Atualizar hotel
- `DELETE /api/hoteis/{id}` - Deletar hotel

### MS Reservas (8083)
- `GET /api/reservas` - Listar todas as reservas
- `GET /api/reservas/{id}` - Buscar reserva por ID
- `POST /api/reservas` - Criar nova reserva
- `PATCH /api/reservas/{id}/confirmar` - Confirmar reserva
- `PATCH /api/reservas/{id}/cancelar` - Cancelar reserva
- `DELETE /api/reservas/{id}` - Deletar reserva

## 🎯 Funcionalidades do Gateway

O Gateway React oferece:
- ✅ Monitoramento em tempo real das requisições
- ✅ Log detalhado com timestamp, serviço, método e status
- ✅ Visualização de dados retornados pelos microsserviços
- ✅ Interface intuitiva para testar os endpoints
- ✅ Suporte a CORS configurado

## 🔧 Tecnologias Utilizadas

### Backend
- Spring Boot 4.0.0 / 3.3.5
- Spring Data JPA
- Spring Cloud Netflix Eureka (Service Discovery)
- Spring Cloud Config
- MySQL 8.0
- WebFlux (para comunicação entre serviços)

### Frontend
- React 19
- TypeScript
- Vite
- Fetch API

## 📝 Estrutura do Projeto

```
reserva_viagens_sistemas_distribuidos/
├── src/
│   ├── backend/
│   │   ├── ms_voos/
│   │   ├── ms_hoteis/
│   │   ├── ms_reservas/
│   │   └── ms_eureka/
│   └── frontend/
│       └── gateway/
└── README.md
```

## 📊 Monitoramento

- **Eureka Dashboard:** http://localhost:8761
- **MS Voos:** http://localhost:8081/api/voos
- **MS Hotéis:** http://localhost:8082/api/hoteis
- **MS Reservas:** http://localhost:8083/api/reservas
- **Gateway Frontend:** http://localhost:5173

## 🤝 Contribuidores

- [Arthur Renato](https://github.com/tuti70)
- [Hugo Machado](https://github.com/Hugo-Machado02)
- [Joselio Jr](https://github.com/JoselioJr)
- [Shayra Kelly](https://github.com/ShayraKelly)
