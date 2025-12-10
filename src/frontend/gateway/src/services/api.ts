const API_BASE_URLS = {
  voos: 'http://localhost:8080/api/voos',
  hoteis: 'http://localhost:8080/api/hoteis',
  reservas: 'http://localhost:8080/api/reservas'
};

export interface LogMessage {
  timestamp: string;
  service: string;
  method: string;
  endpoint: string;
  status: 'success' | 'error' | 'loading';
  message: string;
  data?: any;
}

class ApiService {
  private logCallback?: (log: LogMessage) => void;

  setLogCallback(callback: (log: LogMessage) => void) {
    this.logCallback = callback;
  }

  private log(log: Omit<LogMessage, 'timestamp'>) {
    if (this.logCallback) {
      this.logCallback({
        ...log,
        timestamp: new Date().toLocaleTimeString()
      });
    }
  }

  private async request(service: keyof typeof API_BASE_URLS, endpoint: string, options: RequestInit = {}) {
    const url = `${API_BASE_URLS[service]}${endpoint}`;
    const method = options.method || 'GET';

    this.log({
      service,
      method,
      endpoint,
      status: 'loading',
      message: `Enviando requisição ${method} para ${service} via Gateway...`
    });

    try {
      const response = await fetch(url, {
        ...options,
        headers: {
          'Content-Type': 'application/json',
          ...options.headers
        }
      });

      const data = response.ok ? await response.json().catch(() => null) : null;

      if (response.ok) {
        this.log({
          service,
          method,
          endpoint,
          status: 'success',
          message: `✓ Sucesso: ${response.status} ${response.statusText} via Gateway`,
          data
        });
        return data;
      } else {
        throw new Error(`${response.status} ${response.statusText}`);
      }
    } catch (error: any) {
      this.log({
        service,
        method,
        endpoint,
        status: 'error',
        message: `✗ Erro: ${error.message} via Gateway`
      });
      throw error;
    }
  }

  async getVoos() {
    return this.request('voos', '');
  }

  async getVoo(id: number) {
    return this.request('voos', `/${id}`);
  }

  async createVoo(data: any) {
    return this.request('voos', '', {
      method: 'POST',
      body: JSON.stringify(data)
    });
  }

  async getHoteis() {
    return this.request('hoteis', '');
  }

  async getHotel(id: number) {
    return this.request('hoteis', `/${id}`);
  }

  async createHotel(data: any) {
    return this.request('hoteis', '', {
      method: 'POST',
      body: JSON.stringify(data)
    });
  }

  async getReservas() {
    return this.request('reservas', '');
  }

  async getReserva(id: number) {
    return this.request('reservas', `/${id}`);
  }

  async createReserva(data: any) {
    return this.request('reservas', '', {
      method: 'POST',
      body: JSON.stringify(data)
    });
  }

  async confirmarReserva(id: number) {
    return this.request('reservas', `/${id}/confirmar`, {
      method: 'PATCH'
    });
  }

  async cancelarReserva(id: number) {
    return this.request('reservas', `/${id}/cancelar`, {
      method: 'PATCH'
    });
  }
}

export const apiService = new ApiService();
