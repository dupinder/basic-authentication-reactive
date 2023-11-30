
INSERT INTO role (name, description, created_by, updated_by) VALUES
('Admin', 'Admin', '123e4567-e89b-12d3-a456-426614174001', '123e4567-e89b-12d3-a456-426614174001'),
('User', 'User', '123e4567-e89b-12d3-a456-426614174001', '123e4567-e89b-12d3-a456-426614174001');



INSERT INTO user_account (username, email, password, user_id, role, tenant_id, created_by, updated_by)
VALUES
('Dupinder Singh', 'dupinder@example.com', '$2a$10$MgRSfrQ7SEtsyvynGonge.BVDk5HbJf9XCuIKckNnjKF0izZI9jlK', '550e8400-e29b-41d4-a716-446655440000', '2', '7a1e092e-5102-4a1b-ae54-9d17e01a3c4c', '123e4567-e89b-12d3-a456-426614174001', '123e4567-e89b-12d3-a456-426614174001'),
('Sumanpreet Kaur', 'sumanpreet@example.com', '$2a$10$MgRSfrQ7SEtsyvynGonge.BVDk5HbJf9XCuIKckNnjKF0izZI9jlK', '551e8400-e29b-41d4-a716-446655440001', '1', '7a1e092e-5102-4a1b-ae54-9d17e01a3c4c', '123e4567-e89b-12d3-a456-426614174002', '123e4567-e89b-12d3-a456-426614174002'),
('Paramjot Singh', 'paramjot@example.com', '$2a$10$MgRSfrQ7SEtsyvynGonge.BVDk5HbJf9XCuIKckNnjKF0izZI9jlK', '552e8400-e29b-41d4-a716-446655440002', '2', '7a1e092e-5102-4a1b-ae54-9d17e01a3c4c', '123e4567-e89b-12d3-a456-426614174003', '123e4567-e89b-12d3-a456-426614174003');