#Trie Data Structure#
##What is it?##
Implementation of Trie Data Structure to store phone numbers

-----

##Features##
<ul>
<li>Efficient way to store Phone Numbers</li>
<li>Reduces the memory in storing a lot of phone numbers</li>
</ul>

##Quick Example##
<code>
<pre>
public class TrieTest {
	public static void main(String args[]){
		Trie object = new Trie(); //Creating a new object for Trie 
		object.insert("+919003193845","Name1"); //Adding a phone number
		object.insert("+919840154116","Name2");

		System.out.println(object.search("+919003193845")); //Searching a number
		System.out.println(object.search("+919003148927"));

		System.out.println(object.getName("+919003193845"));
	}
}
</pre>
</code>

##Output##
The output for the above example would be<br/>
true<br/>
false<br/>
Name1