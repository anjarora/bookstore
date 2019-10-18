# Book Store 

## Technologies
Spring-Boot, DI, MVC

## Tools
IntelliJ, Maven, Mongo


### Functional Requirements


1.Add a Book to the store. Mandatory information is ISBN, Title, Author, price. Store might have multiple copies of the same bookEntity.

2.Search bookEntity based on ISBN/Title/Author. Title and Author searches must allow for partial matches too.

3.Search media coverage about a bookEntity, given its ISBN. To find media coverage about the bookEntity, use the public rest API https://jsonplaceholder.typicode.com/posts . If the title of the bookEntity is present in any of the posts’ title or body, then it’s a match. For all posts that match, return the title of the posts in this media coverage API.

4.Buy a bookEntity. No payment related processing is required. 

#### Design And Implementation


1. A bookEntity item contains the following properties 

  * Author
  * Title
  * ISBN
  * Publisher
  * Price
  * Number of copies
  * Current status
  * Keywords
  * Coverage image

3. User should be able to search, add, update, and delete books.


#### Testing Assistance