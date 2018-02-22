	This program implements several key features in the Java programming language that are crucial to understanding how the language works.  The program is centered on different objects, or classes in the Java programming language, that represent shapes and the various data that identifies each shape.  The program offers the user several options to choose from (create circle, create rectangle, create equilateral triangle, count circles, count rectangles, count equilateral triangles, show area, scale, show perimeter, show radius, show width, show height, show diagonal length, show side, show altitude, show type, show all, decimal, clear, and show), each of which will be described in further detail below.  
	The “create circle” command creates an object that is an extension of the object shape, and has several identifying data values stored in it that will show it to be a circle, including: radius, area, and perimeter.  When the option “create circle” is given along with 2 numbers (an address to store the circle and a starting value for the radius of the circle), a new circle object with these identifying values will be created.  The circle will be stored in the specified numbered location in a list of different shapes where it can be referred to later as needed.  The area and perimeter of the circle will automatically be calculated based on the given radius.  
	The “create rectangle” command creates an object that is an extension of the object shape, and has several identifying data values stored in it that will show it to be a rectangle, including: width, height, area, perimeter, and diagonal length.  When the option “create rectangle” is given along with 3 numbers (an address to store the rectangle and a starting value for the width and the height), a new rectangle object with these identifying values will be created.  The rectangle will be stored in the specified numbered location in a list of different shapes where it can be referred to later as needed.  The area, perimeter, and diagonal length of the circle will automatically be calculated based on the given width and height.
	The “create equilateral triangle” command creates an object that is an extension of the object shape, and has several identifying data values stored in it that will show it to be an equilateral triangle, including: the common side, area, perimeter, and altitude.  When the option “create equilateral triangle” is given along with 2 numbers (an address to store the equilateral triangle and a starting value for the common side of the equilateral triangle), a new equilateral triangle object with these identifying values will be created.  The equilateral triangle will be stored in the specified numbered location in a list of different shapes where it can be referred to later as needed.  The area, perimeter, and altitude of the equilateral triangle will automatically be calculated based on the given common side.  
  	Each of the aforementioned commands is similar in that they each create unique objects and store them away for later use.  The rest of the commands are for interacting with the objects that the user has created.  The command “count circles” counts and displays the number of circle objects that have been created, and “count rectangles” and “count equilateral triangles” respectively count and display the number of rectangles and equilateral triangles.  The command “show area” displays the area of any shape in a specified address.  The command “scale” multiplies the size of a shape at any specified address. “Show perimeter” shows the perimeter of any given shape at a specified address.  The commands “show width”, “show height”, and “show diagonal length” display respectively the width, height, and diagonal length of a rectangle object at a specified location, and notifies the user if the object is not a rectangle.  “Show radius” displays the radius of a circle object at a given location, and notifies the user if the object is not a circle.  The commands “show side” and “show altitude” respectively display the common side and the altitude of an equilateral triangle at a specified location, and notifies the user if the object is not an equilateral triangle.  “Show type” shows the type of shape that is stored at the specified location.  “Show all” shows the entire list of stored shapes. “Clear” erases an object from the list at the specified location. And the command “show” displays all of the information on an object at a specified location.  
	The command “decimal” is unique in that in changes the number of decimal points displayed in the commands mentioned above.  The default starting point for the decimal place is 2, or the hundredths spot.  However, should a user want more precise information when displaying their shapes, the user can specify how many decimal places he/she wants to be show by using the command “decimal” and then entering how many decimal places that he/she wishes to be displayed.  