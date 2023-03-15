# Lab Report 5 - Labs Done Quicker

For labs done quick, I ended up using this command: \
`ssh cs15lwi23aqr@ieng6.ucsd.edu "rm -rf repoQuick; git clone git@github.com:wizard1238/lab7.git repoQuick;cd repoQuick;javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java;java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples;sed -i '43s/index1 += 1/index2 += 1/' ListExamples.java;javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java;java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples;git add ListExamples.java;git commit -m "Fixed ListExamples.java";git push"`

This was because using bash scripts was not allowed. So instead, I chained all the commands on one line. Using a bash script instead is not only more repeatable, it looks better and is easier to debug.

Here is the script:

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

sed '43s/index1 += 1/index2 += 1/' ListExamples.java # print out fixed code
sed -i '43s/index1 += 1/index2 += 1/' ListExamples.java # actually fix code

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

The main difference between the output of the bash script and the chained commands I have at the top is the verbosity. The bash script announces each part of the process, so the user knows which step the computer is doing. In addition, when fixing the code, the bash script prints out the fixed code, so the user can confirm that it has been fixed. Also, adding more steps to the script is much easier than adding more steps to the chained commands.

In terms of time, the bash script takes exactly the same amount of time to complete the steps than the chained commands. However, there is less setup needed. I don't need to copy paste a command, or find the command in my history. I can simply `cd` to wherever I left the bash script, and run it.

An issue I found with both the bash script and the chained commands is that there is a lengthy reset process to go through after running the script. Because we had to do the competition multiple times in the lab and then reset afterwards, I wrote a script to reset everything. Here it is:

```bash
git reset --hard 4a2b72172f0a3fd92f617b86091286ebc188b5d0
git push --force
```
The script is very simple. It hard resets the repo to the commit before I started working on it. This resets all my changes to the repo. Then I push the repo with the `--force` flag. Without this flag, The repo would not push because the local repo is no longer in sync with the remote repo after the reset. The `--force` flag forces the push to go through, overwriting everything on the remote.