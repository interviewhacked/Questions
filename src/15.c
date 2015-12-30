/**
 * I have a number in float like 2.5. Store this number in int in such a way that store 2 in bits
31-16 and 5 in 15-0.write a function to do that to convert it and vice versa.

foo(float f)
{
  i = (int) f;
  d = f-i;
  return i << 15 + d*10000;
}
 
unfoo(int N)
{
  return (N & 0xffff/10000.0) + (N >> 15);
}

*/

