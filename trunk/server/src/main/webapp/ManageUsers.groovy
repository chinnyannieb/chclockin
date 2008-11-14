import java.util.Collectionimport org.chcc.chclockin.model.Userimport org.chcc.chclockin.dao.UserDaoimport org.chcc.chclockin.dao.MemoryUserDaodef action = request.getParameter("action")UserDao dao = MemoryUserDao.getInstance();switch (action) {	case "getAllUsers": getAllUsers(dao); break;	case "getUser": getUser(dao); break;	case "addUser": addUser(dao); break;	default: printDefault();}def getAllUsers(UserDao dao) {
	println "GetAllUsers<br/>"	Collection<User> users = dao.getAllUsers()	println "Total users: ${users.size()}<br/>"	users.each() { user ->		println "User Name: ${user.name}"	}}def getUser(UserDao dao) {	println "GetUser"	User user = dao.getUserById(request.getParameter("id"))	println """id: ${user.id} <br/>name: ${user.name}<br/>payRate: ${user.payRate}<br/>role: ${user.role}<br/>ssn: ${user.ssn}<br/>supervisorId: ${user.supervisorId}<br/>	"""}def addUser(UserDao dao) {	if (request.getParameter("id") == null) {		println """<html><head/><body>	<form action="ManageUsers.groovy">		<input type="hidden" name="action" value="addUser"/>		id: <input type="text" name="id"/><br/>		name: <input type="text" name="name"/><br/>		password: <input type="password" name="password"/><br/>		payRate: <input type="text" name="payRate"/><br/>		role: <input type="text" name="role"/><br/>		ssn: <input type="text" name="ssn"/><br/>		supervisorId: <input type="text" name="supervisorId"/><br/>		<input type="submit" label="Submit"/>	</form></body></html>		"""			} else {		User user = new User();		user.id = request.getParameter("id")		user.name = request.getParameter("name")		user.password = request.getParameter("password")		user.payRate = request.getParameter("payRate")		user.role = request.getParameter("role")		user.ssn = request.getParameter("ssn")		user.supervisorId = request.getParameter("supervisorId")		dao.addUser(user)				println "User ${user.name} added"	}}def printDefault() {	println """<a href="ManageUsers.groovy?action=addUser">add user</a><br/><a href="ManageUsers.groovy?action=getAllUsers">get all users</a><br/><form action="ManageUsers.groovy"><input type="hidden" name="action" value="getUser"/>id: <input type="text" name="id"/> <input type="submit" label="get user"/></form>"""}