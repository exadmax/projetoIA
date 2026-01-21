# ProjetoIA - Aplicação Spring Boot com Inteligência Artificial

Aplicação Java Spring Boot que integra funcionalidades de IA utilizando Spring AI e OpenAI.

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior
- Chave de API da OpenAI (para funcionalidades de IA)

## 🏗️ Estrutura do Projeto

```
projetoIA/
├── src/
│   ├── main/
│   │   ├── java/com/exadmax/projetoia/
│   │   │   ├── ProjetoIAApplication.java    # Classe principal
│   │   │   ├── controller/
│   │   │   │   └── IAController.java         # REST endpoints
│   │   │   ├── service/
│   │   │   │   └── IAService.java            # Lógica de negócio IA
│   │   │   ├── model/
│   │   │   │   ├── Conversa.java             # Entidade JPA
│   │   │   │   ├── ChatRequest.java          # DTO de requisição
│   │   │   │   └── ChatResponse.java         # DTO de resposta
│   │   │   ├── repository/
│   │   │   │   └── ConversaRepository.java   # Interface JPA
│   │   │   └── config/
│   │   │       └── CorsConfig.java           # Configuração CORS
│   │   └── resources/
│   │       └── application.properties         # Configurações
│   └── test/
│       └── java/com/exadmax/projetoia/
│           └── ProjetoIAApplicationTests.java # Testes
└── pom.xml                                    # Dependências Maven
```

## 🚀 Como executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/exadmax/projetoIA.git
   cd projetoIA
   ```

2. **Configure a chave da API OpenAI:**
   
   Edite o arquivo `src/main/resources/application.properties` e adicione sua chave:
   ```properties
   spring.ai.openai.api-key=sua-chave-aqui
   ```

3. **Compile e execute a aplicação:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Acesse a aplicação:**
   - API: http://localhost:8080
   - Console H2: http://localhost:8080/h2-console

## 📡 Endpoints da API

### 1. Health Check
```bash
GET /api/ia/health
```

### 2. Enviar mensagem para IA
```bash
POST /api/ia/chat
Content-Type: application/json

{
  "mensagem": "Olá, como você está?"
}
```

**Resposta:**
```json
{
  "resposta": "Olá! Estou bem, obrigado por perguntar...",
  "conversaId": 1
}
```

### 3. Listar todas as conversas
```bash
GET /api/ia/conversas
```

### 4. Buscar conversa específica
```bash
GET /api/ia/conversas/{id}
```

## 🧪 Executar Testes

```bash
mvn test
```

## 🛠️ Tecnologias Utilizadas

- **Spring Boot 3.2.0** - Framework principal
- **Spring AI** - Integração com modelos de IA
- **Spring Data JPA** - Persistência de dados
- **H2 Database** - Banco de dados em memória
- **Lombok** - Redução de código boilerplate
- **Maven** - Gerenciamento de dependências

## 📝 Funcionalidades

- ✅ Integração com OpenAI GPT
- ✅ Armazenamento de conversas em banco de dados
- ✅ API REST para interação
- ✅ Histórico de conversas
- ✅ Console H2 para visualização de dados
- ✅ Configuração CORS para integração frontend

## 🔧 Configuração Avançada

Para personalizar o modelo de IA, edite `application.properties`:

```properties
# Modelo a ser utilizado
spring.ai.openai.chat.options.model=gpt-4

# Temperatura (criatividade das respostas: 0.0 - 1.0)
spring.ai.openai.chat.options.temperature=0.7
```

## 📄 Licença

Este projeto é open source e está disponível para uso educacional.

## 👥 Autor

Desenvolvido por exadmax

