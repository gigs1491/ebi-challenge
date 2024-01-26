# &#9762; Ebi Crud Manager App &#9762;

## Description

This app is fairly design to manage person records in database of an individual or a group. Moreover, you can also add, remove, modify. Feel free to add, remove or modify as many person you want and that's not it!! you also get the details for any person by just typing in person-id.

The service will provide the following endpoint to receive individual track events:
## Service Offerings

1. Creation of persons

*Input*
`HTTP POST /v1/person`
```json
{
    "person": [
        {
            "first_name": "Adam",
            "last_name": "Lawson",
            "age": 44,
            "favourite_colour": "green",
            "hobby": [
                "reading",
                "gardening",
                "cooking"
            ]
        }
    ]
}
```
2. Modifying person by adding and/or removing a person to an already existing person.

*Input*
`HTTP PUT /v1/person/{personId}`
```json
{
    "person": [
      {
            "first_name": "Casey",
            "last_name": "Lord",
            "age": 22,
            "favourite_colour": "orange",
            "hobby": [
                "cricket"
            ]
        }
    ]
}
```
3. Deleting the person

*Input*
`HTTP DELETE /v1/person/{personId}`

4. List All person in db

*Input*
`HTTP GET /v1/person/listAll`


## How to test

1. Clone the repository from https://github.com/gigs1491/ebi-challenge
2. Use Docker pull command `docker pull gagan1491/docker-ebi-springboot:latest`
3. Check the logs on which port its start maybe either `1010` (if docker) or `8080`(if locally)
4. Look for H2 DB JDBC Url.
   ![](misc/images/start-up.png)
5. Open `/h2-console/` on browser and copy-paste the JDBC Url.
   ![](misc/images/h2-console.png)
6. Hit the `HTTP GET /v1/person/listAll` first to see what all data already present in db.
7. You will see the table `Person` & `Hobby` table created with 2 records already inserted.
8. Follow steps from above to add, modify, delete and get person details.

## Considerations
- H2 in memory database is used to store data.
- The code uses hibernate One-to-Many mapping with person and hobby 
- Validation has been added and will throw `EntityNotFoundException` in case of update or delete if `personId` does not exist in DB it will throw 400 BAD_REQUEST.
- Application has already been dockerize!!

Have fun!!
