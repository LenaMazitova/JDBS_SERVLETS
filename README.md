### Проект web-приложения JDBC_SERVLETS без использования Hibernate

В БД реализована связь один ко многим (у одного тренера могут быть несколько атлетов, у атлета - только один тренер).  
В БД реализована связь многие ко многим (у каждого тренера могут быть несколько специализаций, специализация может принадлежать разным тренерам).  
    
Для настройки приложения нужно выполнить скрипты по созданию таблиц в БД:  
  
CREATE TABLE speciality (  
    id SERIAL PRIMARY KEY,  
    description VARCHAR(50) NOT NULL  
);  
  
CREATE TABLE coach (  
    id SERIAL PRIMARY KEY,  
    name VARCHAR(50) NOT NULL,  
    surname VARCHAR(50) NOT NULL,  
);  
  
CREATE TABLE athlete (  
    id SERIAL PRIMARY KEY,  
    name VARCHAR(50) NOT NULL,  
    surname VARCHAR(50) NOT NULL,  
    coach_id INT NOT NULL,  
    FOREIGN KEY(coach_id) REFERENCES coach(id) ON UPDATE CASCADE  
);  
  
CREATE TABLE coach_speciality (  
    coach_id INT REFERENCES coach(id) ON UPDATE CASCADE,  
    speciality_id INT REFERENCES speciality(id) ON UPDATE CASCADE,  
    CONSTRAINT coach_spec_pkey PRIMARY KEY (coach_id, speciality_id) -- explicit pk  
);  
  
Необходимо добавить файл по пути main/resources/config.properties следующего содержания:  
  
db.host=jdbc:postgresql://localhost:5432/название вашей БД  
db.username=наименование пользователя  
db.password=пароль  
  
В терминале выполнить команду mvn clean package.  
Запустить сервер в работу.  
Приложение протестировано с использованием сервера apache-tomcat-10.1.25  
  
PS: приложение нуждается в доработке. В частности, отсутствует обработка ввода некорректных данных   
(отсутствующего id), при выполнении такой команды ожидается ошибка сервера.