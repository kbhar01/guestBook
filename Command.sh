#Start Docker Postgres
docker run -d -p 5432:5432 -e POSTGRES_USER=devuser -e  POSTGRES_PASSWORD=cog -e POSTGRES_DB=guestbookdb --name guestbookpostgres postgres

#Build docker Image
docker build -t guestbook-image .

#Set Git Remote for Heroku
heroku git:remote -a guestbook-koustav-javed
