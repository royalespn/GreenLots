# GreenLots
SpringBoot RESTful API microservice for string manipulation


Create a SpringBoot RESTful API microservice for string manipulation. Use your favorite IDE.


•  Create a SpringBoot project

•  Create a REST controller with the action GET method mapped to url "/manipulate". 

The controller action will accept a mandatory query parameter with name "str", examples:

/manipulate?str=hello

/manipulate?str=JavaDiscussion

• REST controller should delegate processing of "str" to a StringManipulator spring service. Controller should return JSON object of type "Map<String, String>". 
The returned map shall have one key "result" with value as returned from service method.

• Create a StringManipulator spring service with method "manipulate" accepting single parameter "str" and returning String. 
The method should use the following logic to manipulate the string and return the resultant string back:

o            Split the "str" into two equal parts.

If “str” is of even length, split in the middle. (say if ABCD is the passed string, than it will split into AB and CD)

If "str" is of odd length, say ABCDE, split across integer index which is rounded up to length's half. Examples:

- For ABCDE as str, it should be split at index 3 (half 2.5 rounded up to 3) resulting into two parts ABC and DE, the final result should be EDABC

- For CAT as str, it should be split at index 2 (half 1.5 rounded up to 2) resulting into two parts CA and T, the final result should be TCA

o            Reverse the second part, thus CD will become DC

o            Concatenate the reversed second part and the as-is first part (e.g. DC + AB = DCAB)

o            Return the resultant string DCAB

•            Create JUnit test for method "manipulate" in StringManipulator service, run it and ensure it passes.

•            Run the project, hit the URL, and validate that you are indeed getting a JSON result back from the controller.


Notes:

•            You are free to use internet for any reference purpose for entire exercise

•            You'll be evaluated upon best coding practices including those of spring

•            Your general approach towards entire exercises as well as problem solving skills in a real environment will be evaluated as well
