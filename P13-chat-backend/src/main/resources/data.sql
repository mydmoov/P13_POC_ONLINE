 TRUNCATE TABLE message;

-- Insertion de messages d'exemple dans la table message
INSERT INTO message (id, sender, content) VALUES
                                              (1, 'Yumi Ishiyama', 'Bonjour, j’ai besoin d’aide pour ma réservation.'),
                                              (2, 'FullSTACK', 'Bien sûr, comment puis-je vous aider ?'),
                                              (3, 'Yumi Ishiyama', 'Je voudrais modifier ma réservation.'),
                                              (4, 'FullSTACK', 'Pas de problème, donnez-moi plus de détails.'),
                                              (5, 'Yumi Ishiyama', 'Merci pour votre assistance.');
