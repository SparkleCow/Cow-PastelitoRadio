# Cow & Pastelito's Radio

Hi there!

Welcome to Cow & Pastelito's radio, 
a digital platform dedicated to bringing 
a unique experience in music and podcasts. We are passionate about music and truly believe in the power of podcasts to inform, entertain, and connect people.

### What's Cow & Pastelito's Radio ?

Basically, Cow & Pastelito's Radio is a music 
catalog that allows you to explore different 
genres and discover interesting podcasts about 
history, politics, and even entertainment.

### Which tecnologies we used in our project ? 
<br/>

1. Java 17
2. JavaScript
3. HTML & CSS
4. IntelliJ & VisualStudio
5. Spring Framework & SpringBoot
6. Spring Security and JWT
7. Spring JPA - Hibernate 
8. MySQL Workbench 
9. Lombok library
10. Trello
11. Postman

### How does it works ? 

In the first place, we have a database on localhost 
that contains our songs along with their information. 
We utilize our Service classes to access this database
and retrieve songs based on various parameters such 
as artist name, song name, and even genres.

<br/>

![img.png](https://i.pinimg.com/564x/f4/91/d1/f491d17aed89ecda57d027cce385e838.jpg)

![img_1.png](https://i.pinimg.com/564x/b8/3e/25/b83e258bfeb4d27c26c3dbe748607b43.jpg)

Our webpage sends a request to the controller
to retrieve all songs and display them.
<br/>

In the other hand, we have another html file where
we are able to send a personalized request (Filter by gender, artist or name)

![img_2.png](https://i.pinimg.com/564x/9b/fe/2a/9bfe2ab54260560bc437f01a37822b1a.jpg)

<br/>

#### Filter by search

![img_3.png](https://i.pinimg.com/564x/f0/61/92/f061929aaa2f8fa646e64a09d4311a55.jpg)

<br/>

#### Filter by gender (Example - Rock)

![img_4.png](https://i.pinimg.com/564x/c5/60/30/c560306fe18d5c9220c48eb114fb39b2.jpg)

<br/>

#### Podcast section

Regarding our podcasts, we have a selection of them available in a static HTML file. 
In this file, you can find various types of podcasts, including those 
focused on history, politics, and entertainment, 
covering a wide range of topics.

![img.png](https://i.pinimg.com/564x/1a/b4/69/1ab469df3b552eff090e99c70a82d93a.jpg)
![img_1.png](https://i.pinimg.com/564x/b4/43/59/b443592f3f26c6d2d3a2ee14c4ed1439.jpg)

#### Users

Regarding our users, we implemented a registration and login section where people could 
create accounts and log in to our webpage.
However, this accounts are default user provided by JWT
and only those accounts with admin privileges will be able to edit, create
or delete songs from our database. (Currently, these actions can only be performed using 
Postman or Insomnia, as we don't have a user interface on our webpage for these functionalities.)


![img.png](https://i.pinimg.com/564x/92/8e/a7/928ea79aaea862954fdf0061c96eaaca.jpg)
![img_1.png](https://i.pinimg.com/564x/d9/aa/cf/d9aacf996c8542218821c8788de55fb6.jpg)
