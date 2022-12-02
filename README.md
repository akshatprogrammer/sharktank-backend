
# SharkTank Backend

Built a Backend of SharkTank where budding entrepreneurs can pitch ideas for a business or product they wish to develop by providing their name, title & idea for the business, the investment amount they expect to be fulfilled, and the percentage of equity they are ready to shed away to the potential investors. Investors must be able to retrieve the list of all pitches and share their feedback/comments with a counter offer as per their interests.


In this we will be implementing the GET/POST APIs required for the backend to function as per the requirements. The below visual gives a high-level idea of the architecture of the Full Stack Application.




## Pitch Model

![Pitch Model](https://i.imgur.com/SYgPSvg.png)
## Offer Model

![Offer Model](https://i.imgur.com/6o0ahKj.png)

## Tech Used

- Spring Boot 
- Java 11
- Eclipse
- PostgreSQL
- Hibernate 
- Postman 

## API Endpoints

- `/pitches` to retrieve a list of all the pitches made, with the latest one showing first.
- `/pitches/{id}` to get the pitch of the specified ID or 404 not found. 
- `/pitches/{id}/makeOffer` to make an offer on an existing pitch. 
- `/pitches` to send a POST request to post a new pitch. 
