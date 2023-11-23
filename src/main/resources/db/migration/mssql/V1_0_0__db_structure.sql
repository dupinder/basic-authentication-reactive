CREATE TABLE user_account (
      id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
      name VARCHAR(255) NOT NULL,
      email VARCHAR(255) NOT NULL,
      password VARCHAR(255) NOT NULL,
      user_id UNIQUEIDENTIFIER NOT NULL,
      role VARCHAR(255) NOT NULL,
      tenant_id UNIQUEIDENTIFIER NOT NULL,
      created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
      created_by UNIQUEIDENTIFIER NOT NULL,
      updated_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
      updated_by UNIQUEIDENTIFIER NOT NULL
)
GO