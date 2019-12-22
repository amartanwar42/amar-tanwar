# Steps to run mobile tests
 
 ## Note:
 App is automated considering app location as `United States` because based on the location currency changes. Hence please make sure app location is set to `United States`. Here i have used emulator where location is set to `United States`
 
 ## Idea
 * Adding income and expense is most important feature.
 * User should be able to add `income` from both `Cash` and `Card` and `balance` should be updated accordingly.
 * User should be able to add `expense` and `balance` and `expense` should be updated accordingly.
 * Since user has account from both Cash and Card. User should be able to filter `Accounts`.
 * And at last `history` should be updated correctly.
 
 
 ## Scenarios
  Scenarios listed below cover all above mentioned points.
  And below scenarios should pass always and all are High Priority.
 * Add income from Cash(Validate Balance) and add an expense(Validate expense and balance) and finally check the history
 * Add income from Card(Validate Balance) and add an expense(Validate expense and balance) and finally check the history
 * Add income from both Cash and Card(Validate Balance) and check balance for all filters (Card, Cash, All Accounts)
 
 ## Command to run Mobile tests
```bash
mvn clean test -DgroupName=MOBILE
```

# Steps to run API tests

## Note:
* API is expecting some kind of authentication while automating it. Which is no where mentioned in the README.md. 
For reference 
```java
Authentication required
<!--
You are authenticated as: anonymous
Groups that you are in:
  
Permission you need to have (but didn't): hudson.model.Hudson.Read
 ... which is implied by: hudson.security.Permission.GenericRead
 ... which is implied by: hudson.model.Hudson.Administer
-->
```
* But i have created framework to test it.
* If we pass the correct authentication tests will work fine.

## Scenarios
There are multiple apis in swagger. But i have written tests only for `POST`, `GET ` and `DELETE`.
* Pet
    * Create pet
    * Get pet by id
    * Delete pet by id
* Store    
    * Create Store
    * Get Store by id
    * Delete Store by id

* User    
    * Create User
    * Get User by username
    * Delete User by username
    
    
## Command to run API tests
```bash
mvn clean test -DgroupName=API
```