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

INSERT INTO quartos (tipo, capacidade, valor_reserva, disponivel, hotel_id) VALUES 
-- Hotel Paraíso (São Paulo)
('Suite Luxo', 2, 450.00, true, 1),
('Quarto Standard', 2, 250.00, true, 1),
('Quarto Família', 4, 380.00, true, 1),
('Suite Presidencial', 3, 850.00, true, 1),
('Quarto Executivo', 2, 320.00, false, 1),
-- Pousada Tranquilidade (Rio de Janeiro)
('Suite Master', 2, 350.00, true, 2),
('Quarto Simples', 1, 180.00, true, 2),
('Quarto Duplo', 2, 220.00, true, 2),
('Suite Vista Jardim', 2, 280.00, false, 2),
-- Resort Tropical (Salvador)
('Bangalô Premium', 3, 650.00, true, 3),
('Suite Vista Mar', 2, 550.00, true, 3),
('Quarto Standard', 2, 380.00, true, 3),
('Villa Privativa', 6, 1200.00, true, 3),
-- Hotel Executivo (São Paulo)
('Suite Executiva', 2, 420.00, true, 4),
('Quarto Standard', 2, 280.00, true, 4),
('Quarto Single', 1, 200.00, true, 4),
-- Pousada Serra Verde (Campos do Jordão)
('Chalé Casal', 2, 320.00, true, 5),
('Chalé Família', 4, 480.00, true, 5),
('Quarto Standard', 2, 250.00, false, 5),
-- Hotel Copacabana Palace (Rio de Janeiro)
('Suite Imperial', 2, 980.00, true, 6),
('Suite Deluxe', 2, 720.00, true, 6),
('Quarto Superior', 2, 580.00, true, 6),
-- Resort Costa do Sauípe (Salvador)
('Bangalô Luxo', 4, 890.00, true, 7),
('Suite Premium', 2, 680.00, true, 7),
('Apartamento Standard', 2, 450.00, true, 7),
-- Hotel Fazenda Boa Vista (Belo Horizonte)
('Chalé Rústico', 3, 380.00, true, 8),
('Quarto Fazenda', 2, 280.00, true, 8),
('Suite Panorâmica', 2, 420.00, false, 8),
-- Pousada do Arvoredo (Gramado)
('Suite Romântica', 2, 450.00, true, 9),
('Quarto Standard', 2, 320.00, true, 9),
('Apartamento Família', 4, 520.00, true, 9),
-- Hotel Urbano Center (Curitiba)
('Quarto Econômico', 2, 180.00, true, 10),
('Quarto Standard', 2, 240.00, true, 10),
('Suite Executiva', 2, 350.00, false, 10);
