![Starting the container](Documents/img/GJ.png)

# [Gloria Jeans](https://www.gloria-jeans.ru/) [![Build status](https://ci.appveyor.com/api/projects/status/jh32bhm0b7jok1db?svg=true)](https://ci.appveyor.com/project/Aleks4404/gloriajeans)

## [Ефимов Алексей Геннадьевич](https://github.com/Aleks4404)

### [Тестовое задание на QA Automation](Documents/Task.md)

### [Test Plan](Documents/TestPlan.md)

### [Test Case](Documents/TestCase.md)

## Проект

В проекте реализованно автоматизация тест-кейсов основного функционала
интерет-магазина [Gloria Jeans](https://www.gloria-jeans.ru/). Для напиания авто тестов использовался инструмент "
Selenium" в системе автоматизации сборки "Gradle". Проект Gloria Jeans написан на языке Java 11 в интегрированной среде
разработки ПО "Intellij Idea".

## **Перед запуском необходимо выполнить следующие предусловия.**

*Предусловия:*

1. Необходимо скачать и установить интегрированную среду разработки в зависимости от ОС (Windows/macOS/Linux) по
   ссылке [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)
2. Необходимо склонировать репозиторий или скачать архив по
   ссылке [Gloria Jeans](https://github.com/Aleks4404/GloriaJeans.git). Или воспользоваться VCS Git, встроенной в
   IntelliJ IDEA.
3. Установить и запустить Docker Desktop. Это можно сделать [здесь](https://docs.docker.com/get-docker/) в зависимости
   от ОС (Windows/macOS/Linux). Дополнительные инструкции по установке
   Docker [ссылке](https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md)
4. Открыть проект в IntelliJ IDEA.
5. Для успешного запуска и прохождения двух тестов надо выполнить следующие шаги.  
   5.1 Открыть файл [RegistrationFormTest](src/test/java/web/test/RegistrationFormTest.java) и закомитить "@Ignore" у
   тестов "Регистрация с помощью номера телефона", "Авторизация с помощью номера телефона";   
   5.2 Открыть файл [DataHelper](src/test/java/web/data/DataHelper.java) и в методе "generateNamberPhone" стр. 12
   поменять "1234567890", на валидный номер телефона;   
   5.3 После запуска тестов надо вручную ввести код из СМС и нажать "Enter" для регистрации и авторизации.

### Запуск

1. Для запуска необходимо ввести в терминале команду:

> * `docker-compose up --build --force-recreate -d`

2. Проверка работающих контейнеров:

> * `docker ps`

## Запуск автотестов

1. Для запуска тестов, ввести в поле терминала команду:

> * `gradlew clean test`

## Остановка и удаление контейнера

1. Для остановки работы контейнеров "Docker-Compose", необходимо ввести в терминал следующую команду:

> * `docker-compose down`
