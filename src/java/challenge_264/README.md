# Description

Keeping your code clean is one thing. But keeping it sorted is a whole other thing...
Today you will get sorted C++ coded (literaly) like this:


  std::cout << "Hello world!" << std::endl;
}
#include <iostream>
int main () {
And you have to unsort it into this:
#include <iostream>

int main () {
  std::cout << "Hello world!" << std::endl;
}


There are some rules you have to follow:
Lines with #include always shows on top.
Indentation consists out of 2 spaces
Whitespace lines are not obliged
variables have to be defined before used.
Every { must have a } on the same indentation level
Lines that belong to the same method and are of the same indentation, are in order.

# Input Description

You'll be given a program that was sorted


    sum = i + sum;
  {
  }
  int sum = 0
  for (int i = 0; i <= 100; ++i)
  std::cout << sum;
  return 0;
{
}
#include <iostream>
int main()
Output Description

Your program should unsort the lines to something compilable by the compiler:


#include <iostream>

int main()
{
  int sum = 0;
  for (int i = 0; i <= 100; ++i)
  {
    sum = i + sum;
  }
  std::cout << sum;
  return 0;
}
Challenge Input

    sum = i + sum;
  {
  }
  int sum = 0
  for (int i = 0; i <= 100; ++i)
  std::cout << sum;
  return 0;
{
}
#include <iostream>
int main()


# Challenge Output


#include <iostream>
int main()
{
  int sum = 0;
  for (int i = 0; i <= 100; ++i)
  {
    sum = i + sum;
  }
  std::cout << sum;
  return 0;
}
