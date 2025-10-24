# Instruções de Configuração

## Backend (Spring Boot)

### Pré-requisitos
- Java 21
- Maven
- PostgreSQL 15+ ou Docker

### Configuração com Docker (Recomendado)

1. Navegue até o diretório do backend:
```bash
cd tech-solutio-basic-inventory 
```

2. Inicie o banco de dados e a aplicação:
```bash
docker-compose up -d
```

Será executado em `http://localhost:8080`

### Configuração sem Docker

1. Instale o PostgreSQL e crie o banco de dados:
```sql
CREATE DATABASE inventory_db;
```

2. Atualize `src/main/resources/application.properties` com suas credenciais de banco de dados

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

## Endpoints da API

### Serviço de Produtos (Serviço A)
- GET `/api/products` - Obter todos os produtos
- GET `/api/products/{id}` - Obter produto por ID
- POST `/api/products` - Criar produto
- PUT `/api/products/{id}` - Atualizar produto
- DELETE `/api/products/{id}` - Excluir produto

### Serviço de Estoque (Serviço B)
- GET `/api/stock/{productId}` - Verificar status do estoque

## Estrutura do Projeto

### Backend
```
src/main/java/com/techsolutio/inventory/
├── entity/
│   └── Product.java
├── repository/
│   └── ProductRepository.java
├── service/
│   ├── ProductService.java
│   └── StockService.java
├── controller/
│   ├── ProductController.java
│   └── StockController.java
├── dto/
│   ├── ProductDto.java
│   └── StockResponseDto.java
├── exception/
│   └── GlobalExceptionHandler.java
└── InventoryManagementApplication.java
```