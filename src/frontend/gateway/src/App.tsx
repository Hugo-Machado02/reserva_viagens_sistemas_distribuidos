import { useState, useEffect } from 'react';
import { apiService } from './services/api';
import './App.css';

interface LogMessage {
  timestamp: string;
  service: string;
  method: string;
  endpoint: string;
  status: 'success' | 'error' | 'loading';
  message: string;
  data?: any;
}

function App() {
  const [logs, setLogs] = useState<LogMessage[]>([]);
  const [voos, setVoos] = useState<any[]>([]);
  const [hoteis, setHoteis] = useState<any[]>([]);
  const [reservas, setReservas] = useState<any[]>([]);

  useEffect(() => {
    apiService.setLogCallback((log: LogMessage) => {
      setLogs((prev) => [...prev, log]);
    });
  }, []);

  const handleGetVoos = async () => {
    try {
      const data = await apiService.getVoos();
      setVoos(data || []);
    } catch (error) {
      console.error(error);
    }
  };

  const handleGetHoteis = async () => {
    try {
      const data = await apiService.getHoteis();
      setHoteis(data || []);
    } catch (error) {
      console.error(error);
    }
  };

  const handleGetReservas = async () => {
    try {
      const data = await apiService.getReservas();
      setReservas(data || []);
    } catch (error) {
      console.error(error);
    }
  };

  const clearLogs = () => {
    setLogs([]);
  };

  return (
    <div className="app">
      <header>
        <h1>🌍 Sistema de Reserva de Viagens - Gateway</h1>
        <p>Monitoramento de Microsserviços Distribuídos</p>
      </header>

      <div className="container">
        <div className="actions-panel">
          <h2>Ações Disponíveis</h2>
          
          <div className="action-group">
            <h3>✈️ Voos</h3>
            <button onClick={handleGetVoos}>Listar Voos</button>
          </div>

          <div className="action-group">
            <h3>🏨 Hotéis</h3>
            <button onClick={handleGetHoteis}>Listar Hotéis</button>
          </div>

          <div className="action-group">
            <h3>📋 Reservas</h3>
            <button onClick={handleGetReservas}>Listar Reservas</button>
          </div>

          <button onClick={clearLogs} className="clear-btn">🗑️ Limpar Logs</button>
        </div>

        <div className="log-panel">
          <div className="log-header">
            <h2>📊 Log de Requisições</h2>
            <span className="log-count">{logs.length} mensagens</span>
          </div>
          
          <div className="log-content">
            {logs.length === 0 ? (
              <div className="empty-log">
                Nenhuma requisição realizada ainda. Clique em uma ação para começar.
              </div>
            ) : (
              logs.map((log, index) => (
                <div key={index} className={`log-entry ${log.status}`}>
                  <div className="log-time">[{log.timestamp}]</div>
                  <div className="log-service">{log.service.toUpperCase()}</div>
                  <div className="log-method">{log.method}</div>
                  <div className="log-message">{log.message}</div>
                  {log.data && (
                    <details className="log-data">
                      <summary>Ver dados</summary>
                      <pre>{JSON.stringify(log.data, null, 2)}</pre>
                    </details>
                  )}
                </div>
              ))
            )}
          </div>
        </div>

        <div className="data-panel">
          <h2>📦 Dados Recebidos</h2>
          
          {voos.length > 0 && (
            <div className="data-section">
              <h3>Voos ({voos.length})</h3>
              <div className="data-list">
                {voos.map((voo, i) => (
                  <div key={i} className="data-item">
                    {voo.origem} → {voo.destino} | {voo.dataPartida}
                  </div>
                ))}
              </div>
            </div>
          )}

          {hoteis.length > 0 && (
            <div className="data-section">
              <h3>Hotéis ({hoteis.length})</h3>
              <div className="data-list">
                {hoteis.map((hotel, i) => (
                  <div key={i} className="data-item">
                    {hotel.nome} - {hotel.cidade}
                  </div>
                ))}
              </div>
            </div>
          )}

          {reservas.length > 0 && (
            <div className="data-section">
              <h3>Reservas ({reservas.length})</h3>
              <div className="data-list">
                {reservas.map((reserva, i) => (
                  <div key={i} className="data-item">
                    ID: {reserva.id} | Status: {reserva.status}
                  </div>
                ))}
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default App;
