package Dao;

import Modal.TestModal;

public class TestDao
{

	public TestModal createTest(TestModal modal)
	{
		System.out.println("First Name :" + modal.getFirstName());
		System.out.println("Last Name :" + modal.getLastName());
		System.out.println("Email :" + modal.getEmail());
		System.out.println("Phone :" + modal.getPhone());
		modal.setId(2);
		return modal;
	}

}
