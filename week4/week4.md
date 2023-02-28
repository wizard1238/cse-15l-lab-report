# Lab Report 4 - Labs Done Quick

## First Steps

For this lab, I first ran through all the steps manually to validate all the commands. For each step, I've listed out the keys I pressed, my clipboard, and the resulting output. 

### Step 1: Logging in

Clipboard: `cs15lwi23aqr` \
Keys: ssh `<ctrl> + <v>` @ieng6.ucsd.edu `<enter>`\
Output: 
```bash
jeremy@tsubaki ~ % ssh cs15lwi23aqr@ieng6.ucsd.edu 
Last login: Mon Feb 27 22:21:57 2023 from <ip-address>
Hello cs15lwi23aqr, you are currently logged into ieng6-203.ucsd.edu

You are using 0% CPU on this system

Cluster Status 
Hostname     Time    #Users  Load  Averages  
ieng6-201   22:30:01   22  2.04,  0.78,  0.38
ieng6-202   22:30:01   24  0.14,  0.10,  0.15
ieng6-203   22:30:01   20  0.34,  0.29,  0.29


       *** Network Delay Issue ***
	 2023-01-24 - 2023-01-31 11:30

The security team seem to have identified
the root cause of the network issues in
one of the network firewall modules and 
remedied the issue. If you encounter any
ongoign issues please report them to the
service desk.



 
Mon Feb 27, 2023 10:32pm - Prepping cs15lwi23
```

Summary: Pretty self explanatory.

### Step 2: Cloning the repository

Clipboard: `git@github.com:wizard1238/lab7.git` \
Key: git clone `<ctrl> + <v>` repoQuick `<enter>`\
Output:
```bash
[cs15lwi23aqr@ieng6-203]:~:335$ git clone git@github.com:wizard1238/lab7.git repoQuick
Cloning into 'repoQuick'...
remote: Enumerating objects: 29, done.
remote: Total 29 (delta 0), reused 0 (delta 0), pack-reused 29
Receiving objects: 100% (29/29), 370.22 KiB | 1.39 MiB/s, done.
Resolving deltas: 100% (11/11), done.
```

Summary: Cloned the repo, giving it a custom name.

### Step 3: Running the tests

Clipboard: empty \
Keys: cd repo`<tab>` \
Output:
```bash
[cs15lwi23aqr@ieng6-203]:~:336$ cd repoQuick/
```

Clipboard: `javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java` \
Keys: `<ctrl> + <v>` \
Output:
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:337$ javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
```

Clipboard: `java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore ArrayTests` \
Keys: `<ctrl> + <v>, <backspace> * 10` TestListEx`<tab>, <backspace>, <enter>`  \
Output:
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:345$ java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
JUnit version 4.13.2
..E
Time: 0.775
There was 1 failure:
1) testMerge2(TestListExamples)
org.junit.runners.model.TestTimedOutException: test timed out after 500 milliseconds
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:267)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:241)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:233)
	at java.util.ArrayList.add(ArrayList.java:464)
	at ListExamples.merge(ListExamples.java:42)
	at TestListExamples.testMerge2(TestListExamples.java:19)

FAILURES!!!
Tests run: 2,  Failures: 1
```

Summary: Ran the tests, copying the compile and run commands from the week 3 lab document.

### Step 4: Fixing the code
Clipboard: empty \
Keys: sed -i '43s/index1 += 1/index2 += 1/' ListEx `<tab` j `<tab><enter>` \
Output
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:347$ sed -i '43s/index1 += 1/index2 += 1/' ListExamples.java 
```

Summary: After looking at the code on GitHub to determine the bug, I fixed it with the sed command.

### Step 5: Running the tests again
Clipboard: empty \
Keys: `<up> * 4, <enter>` \
Output:
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:348$ javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
```

Clipboard: empty \
Keys: `<up> * 4, <enter>` \
Output:
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:349$ java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
JUnit version 4.13.2
..
Time: 0.013

OK (2 tests)
```

Summary: Same as step 3.

### Step 6: Pushing and commiting
Clipboard: empty \
Keys: git add ListEx`<tab>` j `<enter>` \
Output:
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:350$ git add ListExamples.java
```

Clipboard: empty \
Keys: git commit -m "Fixed ListExamples.java" `<enter>` \
Output:
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:351$ git commit -m "Fixed ListExamples.java"
[main 86ad163] Fixed ListExamples.java
 1 file changed, 1 insertion(+), 1 deletion(-)
```

Clipboard: empty \
Keys: git push `<enter>` \
Output: 
```bash
[cs15lwi23aqr@ieng6-203]:repoQuick:351$ git commit -m "Fixed ListExamples.java"
[main 86ad163] Fixed ListExamples.java
 1 file changed, 1 insertion(+), 1 deletion(-)
[cs15lwi23aqr@ieng6-203]:repoQuick:352$ git push
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 358 bytes | 179.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To github.com:wizard1238/lab7.git
   4a2b721..86ad163  main -> main
```

Summary: Added, commited, and pushed the code.

## Bash Script
I then took all these commands and turned them into a bash script, to further speed up the process. However, after asking the TA's, this was not allowed. The script is still included below because it is a more elegant way to the same thing I did in the next step.

Bash Script:
```bash
echo "-----------------------------------"
echo "Cloning Git Repo"
echo "-----------------------------------"

rm -rf repoQuick

git clone git@github.com:wizard1238/lab7.git repoQuick

cd repoQuick

echo "-----------------------------------"
echo "Running Tests"
echo "-----------------------------------"

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples


echo "-----------------------------------"
echo "Fixing code"
echo "-----------------------------------"

sed '43s/index1 += 1/index2 += 1/' ListExamples.java
sed -i '43s/index1 += 1/index2 += 1/' ListExamples.java

echo "-----------------------------------"
echo "Running Tests Again"
echo "-----------------------------------"

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples

echo "-----------------------------------"
echo "Commiting and Pushing"
echo "-----------------------------------"

git add ListExamples.java
git commit -m "Fixed ListExamples.java"
git push


echo "-----------------------------------"
echo "Done!"
echo "-----------------------------------"
```

## Chaining Commands
I then took all the commands from the bash script, and chained them together on one line. The resulting command is below. \
`"rm -rf repoQuick; git clone git@github.com:wizard1238/lab7.git repoQuick;cd repoQuick;javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java;java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples;sed -i '43s/index1 += 1/index2 += 1/' ListExamples.java;javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java;java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples;git add ListExamples.java;git commit -m "Fixed ListExamples.java";git push"`

## Final Optimization
I realized that I could include the `ssh` command as well, and everything is now on one line. The final command is as follows: \
`ssh cs15lwi23aqr@ieng6.ucsd.edu "rm -rf repoQuick; git clone git@github.com:wizard1238/lab7.git repoQuick;cd repoQuick;javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java;java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples;sed -i '43s/index1 += 1/index2 += 1/' ListExamples.java;javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java;java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples;git add ListExamples.java;git commit -m "Fixed ListExamples.java";git push"`