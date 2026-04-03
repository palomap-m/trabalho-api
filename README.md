### Subir o Docker
```bash
docker-compose up -d
```

### Acessar o MySQL
```bash
docker exec -it mysql mysql -u root -prootpass
```

### Inserir o usuário
```sql
USE application;

INSERT INTO usuarios (nome_de_usuario, senha) 
VALUES ('admin', '<hash_gerado>'); -- hash gerado com Bcrypt

SELECT * FROM usuarios;

EXIT;
```

### Rodar a aplicação
```bash
gradle bootRun
```

### Autenticação
- Send request no arquivo `auth.http`
- Copiei o token fornecido e coloquei no arquivo `sensores.http`

