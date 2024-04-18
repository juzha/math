/*
* Let n be a positive integer. A group of n friends are standing in a circle labeled 1 to n
* in clockwise order. Person 1 leaves the circle. Whenever a person leaves the circle, the 
* person who previously stood two places to the right leaves the circle next. This process 
* continues until only one person remains. For example, if n = 10, the friends leave the circle
* in the order 1,3,5,7,9,2,6,10,8, meaning that person 4 is the last one standing.
*/

fun main() {
    val n = 10
    print(remain(n, 0))
}

/*
 * n: number of the friends
 * start: start position 
 */
fun remain(n: Int, start: Int): Int{
    if (n == 1) return 1;
    val used = Array(n){_ -> false}
    used[start] = true;
    var remained = n-1;
    var cur = start;
    
    while ( remained > 1) {
        var next = 2;
        while (next > 0)
        {
            cur++;
            cur %= n;
            if (!used[cur])
            {
                next--;
            }
        }
        used[cur] = true;
        remained--;
    }
	for(i in 0..n-1)
    {
        if (!used[i]) return i+1;
    }
    return 0;
}
