# csvReader
CSV reader application

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is a simple REST application in Java that allows you to upload a text file (CSV) containing user data. The file is loaded, processed and stored in memory database.
User can display information about:
- how many users are there in total,
- list of users sorted by age (data to be written out: name, surname, age, phone number),
- the oldest user with a phone number,
and do the following:
- remove the selected user or the entire list from the database,
- search for users by surname.

Available requests:

POST:
/loadFile

GET:
/client/countAll
/client/getAll
/client/getClientsListSortedByAge
/client/getOldestClient

## Technologies
Project is created with:
* Java 16
* mySQL
* Spring
* Hibernate
	
## Setup
To run this project, clone the repository:

```bash
git clone https://github.com/WojtekMalka/csvReader.git
```
