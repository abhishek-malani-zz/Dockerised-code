docker build -f Dockerfile -t abhishek/linkedin:1 .
docker run --rm -v $PWD:/app -w /app abhishek/linkedin:1 javac MainClass.java Person.java FriendshipManager.java
docker run --rm -v $PWD:/app -w /app abhishek/linkedin:1 java MainClass