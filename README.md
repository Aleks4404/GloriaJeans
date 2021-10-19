![Starting the container](Documents/img/GJ.png)
# [Gloria Jeans](https://www.gloria-jeans.ru/) [![Build status](https://ci.appveyor.com/api/projects/status/jh32bhm0b7jok1db?svg=true)](https://ci.appveyor.com/project/Aleks4404/gloriajeans)
## [Ефимов Алексей Геннадьевич](https://github.com/Aleks4404) 
### [Тестовое задание на QA Automation](Documents/Task.md)
### [Test Plan](Documents/TestPlan.md)
### [Test Case](Documents/TestCase.md)

## Проект

В проекте реализованно автоматизация тест-кейсов основного функционала интерет-магазина [Gloria Jeans](https://www.gloria-jeans.ru/).
Для напиания авто тестов использовался инструмент "Selenium" в системе автоматизации сборки "Gradle". 
Проект Gloria Jeans написан на языке Java 11 в  интегрированной среде разработки ПО "Intellij Idea". 

## Подготовительные действия (установки, настройки и т.д) для успешной работы

**Перед запуском необходимо выполнить следующие предусловия.**

*Предусловия:*
1. Необходимо скачать и установить интегрированную среду разработки в зависимости от ОС (Windows/macOS/Linux) по ссылке [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)
2. Необходимо склонировать репозиторий или скачать архив по  ссылке [Gloria Jeans](https://github.com/Aleks4404/GloriaJeans.git). Или воспользоваться VCS Git, встроенной в  IntelliJ IDEA.
3. Установить и запустить Docker Desktop. Это можно сделать [здесь](https://docs.docker.com/get-docker/) в зависимости от ОС (Windows/macOS/Linux). Дополнительные инструкции по установке Docker [ссылке](https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md)
4. Открыть проект в IntelliJ IDEA

### Запуск



## Запуск автотестов


## Запуск отчета тестирования

1. Для запуска и просмотра отчета по результатам тестирования, с помощью "Allure", выполнить по очереди команды:
> * `gradlew allureReport`
> * `gradlew allureServe`

## Завершения работы Sut

1. Для завершения работы SUT, необходимо в терминале, где был запущен SUT, ввести команду:
> * `Ctrl+C`

## Остановка и удаление контейнера
1. Для остановки работы контейнеров "Docker-Compose", необходимо ввести в терминал следующую команду:

> * `docker-compose down`
