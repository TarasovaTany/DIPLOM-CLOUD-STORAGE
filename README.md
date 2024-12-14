# Дипломная работа «Облачное хранилище»

## Описание проекта

Задача — разработать REST-сервис. Сервис должен предоставить REST-интерфейс для загрузки файлов и вывода списка уже загруженных файлов пользователя. 
Все запросы к сервису должны быть авторизованы. Заранее подготовленное веб-приложение (FRONT) должно подключаться к разработанному сервису без доработок, а также использовать функционал FRONT для авторизации, загрузки и вывода списка файлов пользователя.

## Требования к приложению

- Сервис должен предоставлять REST-интерфейс для интеграции с FRONT.
- Сервис должен реализовывать все методы, описанные в [yaml-файле](./CloudServiceSpecification.yaml):
  1. Вывод списка файлов.
  2. Добавление файла.
  3. Удаление файла.
  4. Авторизация.
- Все настройки должны вычитываться из файла настроек (yml).
- Информация о пользователях сервиса (логины для авторизации) и данные должны храниться в базе данных (на выбор студента).
  
## Требования к реализации

- Приложение разработано с использованием Spring Boot.
- Использован сборщик пакетов gradle/maven.
- Для запуска используется docker, docker-compose
- Код размещён на Github.
- Код покрыт unit-тестами с использованием mockito.
- Добавлены интеграционные тесты с использованием testcontainers.
  
## Шаги реализации

- Изучите протокол получения и отправки сообщений между FRONT и BACKEND.
- Нарисуйте схему приложений.
- Опишите архитектуру приложения, где хранятся настройки и большие файлы, структуры таблиц/коллекций базы данных.
- Создайте репозиторий проекта на Github.
- Напишите приложение с использованием Spring Boot.
- Протестируйте приложение с помощью curl/postman.
- Протестируйте приложение с FRONT.- Напишите README.md к проекту.
- Отправьте на проверку.## Описание и запуск FRONT
  1. Установите nodejs (версия не ниже 19.7.0) на компьютер, следуя [инструкции](https://nodejs.org/ru/download/current/).
  2. Скачайте [FRONT](./netology-diplom-frontend) (JavaScript).
  3. Перейдите в папку FRONT приложения и все команды для запуска выполняйте из неё.
  4. Следуя описанию README.md FRONT проекта, запустите nodejs-приложение (`npm install`, `npm run serve`).
  5. Далее нужно задать url для вызова своего backend-сервиса.
     1. В файле `.env` FRONT (находится в корне проекта) приложения нужно изменить url до backend, например: `VUE_APP_BASE_URL=http://localhost:8080`.
        a. Нужно указать корневой url вашего backend, к нему frontend будет добавлять все пути согласно спецификации
        b. Для `VUE_APP_BASE_URL=http://localhost:8080` при выполнении логина frontend вызовет `http://localhost:8080/login`
     2. Запустите FRONT снова: `npm run serve`.
     3. Изменённый `url` сохранится для следующих запусков.
  6. По умолчанию FRONT запускается на порту 8080 и доступен по url в браузере `http://localhost:8080`.
     1. Если порт 8080 занят, FRONT займёт следующий доступный (`8081`). После выполнения `npm run serve` в терминале вы увидите, на каком порту он запустился.
        
## Авторизация приложения

FRONT-приложение использует header `auth-token`, в котором отправляет токен (ключ-строка) для идентификации пользователя на BACKEND. Для получения токена нужно пройти авторизацию на BACKEND и отправить на метод /login логин и пароль. В случае успешной проверки в ответ BACKEND должен вернуть json-объектс полем `auth-token` и значением токена. Все дальейшие запросы с FRONTEND, кроме метода /login, отправляются с этим header.Для выхода из приложения нужно вызвать метод BACKEND /logout, который удалит/деактивирует токен. Последующие запросы с этим токеном будут не авторизованы и вернут код 401.
Обратите внимание, что название самого параметра (как и всех параметров в спецификации), его регистр имеют значение. Важно, чтобы ваш backend возвращал токен в поле `auth-token` – если поле будет называться `authToken` или `authtoken`, фронт не сможет найти токен и дальше логина процесс не пройдёт.

----
Для аутентификации необходимо ввести логин и пароль одного из пользователей:
1. Логин: tany, пароль: pass
1. Логин: test_name, пароль: #pass#
