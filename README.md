# wallet-service

## Why
We need to develop a microservice to manage the wallet of the customers.
There are different actions that can be done, and in some cases, we need to validate with another third party services the transactions

## How
* Run class WalletApplication: 

This starts the application and expose some paths (defined in WalletController) to do any action relative to wallet

Because this is a trial, and how was requested, only these calls work:
* @GetMapping(path = "/get/{walletId}")
* @PostMapping(path = "/create")
* @PostMapping(path = "/load")

## Where
* WalletControllerTest: Integration test which checks: create, find and load wallet
* LoadWalletServiceActionTest: checks the business logic to load the wallet
* WalletEntityManagerTest: checks actions on the repository, unfinished
* StripeServiceTest: it was given, just fixed

## What
This is a basic structure, where each package has its own logic. We work with segregate interfaces

* api: Controller to receive the requests. We have to subpackages to define the objects in/out the service
* business: The main logic of the service
* domain: main pojos in this service
* exception: all defined errors and its handler
* provider: external service or logic that is needed in this project
* repository: logic to persist information. In this case, in a database. There is entity objects to separate from domain objects.


## Who
* **Alvaro Longueira** - [alvarolongueira](https://github.com/alvarolongueira)


