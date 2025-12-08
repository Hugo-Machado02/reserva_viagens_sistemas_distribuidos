-- Dados de exemplo para o microserviço de hotéis

INSERT INTO hoteis (nome, endereco, cidade, estrelas) VALUES 
('Hotel Paraíso', 'Rua das Flores, 123', 'São Paulo', 5),
('Pousada Tranquilidade', 'Av. Beira Mar, 456', 'Rio de Janeiro', 4),
('Resort Tropical', 'Praia do Sol, 789', 'Salvador', 5),
('Hotel Executivo', 'Av. Paulista, 1000', 'São Paulo', 4),
('Pousada Serra Verde', 'Estrada da Serra, 500', 'Campos do Jordão', 3),
('Hotel Copacabana Palace', 'Av. Atlântica, 1702', 'Rio de Janeiro', 5),
('Resort Costa do Sauípe', 'Rodovia BA-099, km 76', 'Salvador', 5),
('Hotel Fazenda Boa Vista', 'Zona Rural, s/n', 'Belo Horizonte', 4),
('Pousada do Arvoredo', 'Rua das Acácias, 88', 'Gramado', 4),
('Hotel Urbano Center', 'Rua XV de Novembro, 300', 'Curitiba', 3);

INSERT INTO quartos (tipo, numero, capacidade, valor_reserva, disponivel, hotel_id) VALUES 
-- Hotel Paraíso (São Paulo)
('Suite Luxo', 501, 2, 450.00, true, 1),
('Standard', 302, 2, 250.00, true, 1),
('Família', 405, 4, 380.00, true, 1),
('Suite Presidencial', 601, 3, 850.00, true, 1),
('Executivo', 203, 2, 320.00, false, 1),
-- Pousada Tranquilidade (Rio de Janeiro)
('Suite Master', 301, 2, 350.00, true, 2),
('Simples', 105, 1, 180.00, true, 2),
('Duplo', 208, 2, 220.00, true, 2),
('Suite Vista Jardim', 402, 2, 280.00, false, 2),
-- Resort Tropical (Salvador)
('Premium', 101, 3, 650.00, true, 3),
('Suite Vista Mar', 205, 2, 550.00, true, 3),
('Standard', 310, 2, 380.00, true, 3),
('Villa Privativa', 501, 6, 1200.00, true, 3),
-- Hotel Executivo (São Paulo)
('Executivo', 401, 2, 420.00, true, 4),
('Standard', 305, 2, 280.00, true, 4),
('Single', 210, 1, 200.00, true, 4),
-- Pousada Serra Verde (Campos do Jordão)
('Confort', 102, 2, 320.00, true, 5),
('Família', 205, 4, 480.00, true, 5),
('Standard', 308, 2, 250.00, false, 5),
-- Hotel Copacabana Palace (Rio de Janeiro)
('Suite Imperial', 801, 2, 980.00, true, 6),
('Suite Deluxe', 705, 2, 720.00, true, 6),
('Superior', 610, 2, 580.00, true, 6),
-- Resort Costa do Sauípe (Salvador)
('Premium', 201, 4, 890.00, true, 7),
('Suite Premium', 305, 2, 680.00, true, 7),
('Standard', 410, 2, 450.00, true, 7),
-- Hotel Fazenda Boa Vista (Belo Horizonte)
('Confort', 105, 3, 380.00, true, 8),
('Standard', 208, 2, 280.00, true, 8),
('Suite Panorâmica', 301, 2, 420.00, false, 8),
-- Pousada do Arvoredo (Gramado)
('Suite Romântica', 201, 2, 450.00, true, 9),
('Standard', 305, 2, 320.00, true, 9),
('Família', 410, 4, 520.00, true, 9),
-- Hotel Urbano Center (Curitiba)
('Econômico', 105, 2, 180.00, true, 10),
('Standard', 210, 2, 240.00, true, 10),
('Executivo', 315, 2, 350.00, false, 10);
