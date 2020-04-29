# assign5git
Requirements fulfilled by each design pattern:

Abstract Factory:
•	“A new world must start with at least 1 farm.”
The program allows the user to choose how many farms to simulate, but yes, the abstract builder will build at least one farm of the chosen type.
•	“Farms can be of different types, such as an animal farm, a crop farm, a hybrid farm
and so on.”
The program also allows the user to choose which type of farm(s) to simulate (animal, crop or hybrid).
Decorator:
•	“More currency can be made from farmer, animal or crop affinities.”
Decorated farmers have higher stats which in turn allow more product to be made, sold, at higher prices, etc.
•	“Farmers can have affinities for things”
A basic farmer has randomly generated but low base stats.  Once a farmer is decorated, their stats are significantly increased with the stat pertaining to their trade being maxed out.
Mediator:
•	“The simulation should run on cycles. A cycle is considered to be of 2 parts - 1 day
time and 1 night time.”
The program loops through these cycles until the farm reaches level 5.
•	“Passive currency is earned with each new day (not night).”
Money is earned through the sales of meat, eggs, wool, crops, etc. each day.
•	“Farms are automatically upgraded once the farm has acquired enough currency.”
When a farm reaches the the level up threshold for money, it levels up automatically the next day.
•	“Animal product (milk, wool, and so on) is replenished after every 2nd day.”
The mediator allows these products to be sold every other day.
•	“During night cycles predators come out”
There is a chance each night for an animal to be killed by a wolf.
•	“Animals live for 14 days unless killed by a predator or they become diseased.”
The mediator controls the lifespan, although disease and predators may kill the animal early.
•	“They start as a baby where they cannot produce anything for the first 3 days”
Animals may not be sold, become pregnant or make products until 3 days old.
•	“Crops are grown on farms and have a chance to become diseased.”
There is a daily chance.
•	“Crops may be harvested 1 time every 3 cycles.”
There is a three-day product cycle.

Multiple design patterns:
•	“Animals reside on farms”
The abstract factory begins animal and hybrid farms with some initial animals.  The mediator each day buys or sells additional animals.
•	“Animals have a chance to be born every 4 cycles”
The mediator controls the timeline, the abstract factory creates new animal from animals that are pregnant.
•	“Animals and crops cost currency to purchase.”
The mediator controls when purchase which triggers the abstract factory to create the products.
Design Patterns (extra credit):
As shown above, the mediator controls the simulation logic and therefore meets most of the requirements itself.  The mediator however, is extremely dependent 
on the abstract factory.  Anytime, a farmer is hired, an animal born or purchased, crops planted, the mediator calls the abstract factory.  This can happen 
several times per cycle.  The decorator is also heavily dependent upon the abstract factory.  When “promoting” a farmer with the decorator, it calls the 
abstract factory to create new farmer of the correct type with the boosted stats.  The decorator is also dependent upon the mediator, since the mediator 
allows a promotion once per 10 days.

Screencast link: https://youtu.be/YKtB1_mj2QM