Система мониторинга бортовых датчиков автобуса
===============================================

Описание
--------
Система сбора, хранения и анализа данных с бортовых датчиков автобуса в реальном времени.

Технологии
----------
- Java 17
- Spring Boot 3.2.0
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Swagger/OpenAPI
- Maven

Запуск проекта
--------------

Требования
~~~~~~~~~~
- Java 17
- PostgreSQL 17
- Maven

Настройка базы данных
~~~~~~~~~~~~~~~~~~~~~
```sql
CREATE DATABASE bus_monitor;
CREATE USER bus_user WITH PASSWORD 'bus123';
GRANT ALL PRIVILEGES ON DATABASE bus_monitor TO bus_user;


Запуск приложения

```bash
mvn spring-boot:run
```

API документация
----------------
После запуска: http://localhost:8080/swagger-ui/index.html

Тестовый пользователь
---------------------
- **Логин:** admin
- **Пароль:** 123

API Endpoints
-------------

| Метод | Эндпоинт | Описание |
|-------|----------|----------|
| POST | /api/auth/login | Авторизация (получение JWT токена) |
| POST | /api/sensors | Отправить данные датчика |
| GET | /api/sensors/latest | Получить последние показания |
| GET | /api/sensors/history | Получить историю показаний |
| GET | /api/sensors/alerts | Получить список аномалий |

Автор
-----
Ameno63