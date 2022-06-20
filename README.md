# PolicyManager : Gadget Insurance Policy Prototype 


Gadget Protector requires a simple insurance premium calculator prototype to demonstrate key features.
The basic insurance premium is calculated based on the number of gadgets and the value of the most expensive item as listed in the Monthly Premiums table below.

![image](https://user-images.githubusercontent.com/79797338/174554668-0e19984e-9ebb-42af-81cc-836ab5a1a019.png)

Gadget Protector charges an excess (the amount the client will have to pay) of £30 for each claim.  Clients can choose to increase this up to £70.00 (in multiples of 10) to reduce the premium – for each £10 increase the premium is reduced by 5%.
The default payment term is monthly, however, customers can choose to pay annually to receive an additional 10% discount.
As well as entering the inputs identified above, the user will also provide the following:
•	Policy reference number (eg: JB123A – two letters, three digits and a letter).
•	Client name (eg: J Smith – maximum of 20 characters)
Once the validation/calculation has been completed, a policy summary should be output:

![image](https://user-images.githubusercontent.com/79797338/174555121-dc9f66a2-972b-4e8e-86ec-80107fb9b409.png)

 
 This is a prototype for premium calculator, but to implement this full system there are some points which are very important:
•	To safeguard the data company should:
      o	Give individual employee id and password to login in system and mark changes via this and store it in database, for example, which policy is sold by which employee, or what changes employee made in the policy manually.
      o	Extra data should be asked by user to verify the user, like date of birth. For example, if user ask to show his policy in option 4, before printing its policy it should ask for date of birth for verification. This will also help to print correct user’s data, there can be two persons with same name, thus this will help to differentiate.
      o	Every employee id should be given access to the data which it needs. For example, only manager should be able to see the summary of policies (option 2 & 3), there is no need of employees to see this data. There should be special employees who would be able to see the user’s data (option 4) like an enquiry desk.
•	Some legal considerations need to be taken:
    o	GPDR: Regulation on the protection of natural persons with regard to the processing of personal.
    o	The data should be updated time to time and user should be informed what data we need and how we will use it.
    o	Every user should be given an invoice which should include how much customer needs to pay us and when he needs to pay us.
•	Development and implementation risks:
    o	Time to time cloud backups should be done.
    o	Before implementation of any updates, testing should be done in a proper manner.
    o	The person developing application should be given proper information of the application.
•	Current state of prototype
    o	This prototype is working as the company asked but there is some advice I would like to give:
        	Company should also ask for dare of birth.
        	Every device’s IMEI and Mac address should be noted.



