class Solution 
fun Solution.isRationalEqual(s: String, t: String) =
    toFraction(s) == toFraction(t)

data class Fraction(val a:Long,val b:Long){
    operator fun plus(x:Long) = newFraction(x*b+a,b)
    operator fun div(x:Long) = newFraction(a,b*x)
}
fun newFraction(a:Long,b:Long):Fraction{
    if(a==0L) return Fraction(0L,1L)
    val x = gcd(a,b)
    return Fraction(a/x,b/x)
}
fun newFraction(a:String,b:String):Fraction{
    if(a=="") return Fraction(0L,1L)
    return Fraction(a.toLong(),b.toLong())
}
fun toFraction(s:String):Fraction{
    var i = 0
    while(i<s.length && s[i]!='.') i++
    val integer = s.substring(0,i).toLong()
    var j = i+1
    while(j<s.length && s[j]!='(') j++
    val nonRepeating = if(j<=s.length) s.substring(i+1,j) else ""
    val repeating = if(j<s.length-1) s.substring(j+1,s.length-1) else ""
    // 循环节分数表示
    var fraction = newFraction(repeating,"9".repeat(repeating.length))
    if(nonRepeating!=""){
        fraction += nonRepeating.toLong()
        fraction /= ("1"+"0".repeat(nonRepeating.length)).toLong()
    }
    return fraction+integer
}


tailrec fun gcd(a:Long,b:Long):Long{
    if(a<b) return gcd(b,a)
    if(b==0L) return a
    return gcd(b,a%b)
}
