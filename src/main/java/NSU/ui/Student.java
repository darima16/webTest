/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package NSU.ui;

import java.util.Calendar;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Rob Winch
 */
public class Student {

	private Long id;

	@NotEmpty(message = "Name is required.")
	private String name;

	private String ident;

	@NotEmpty(message = "SecondName is required.")
	private String secondName;

	@NotEmpty(message = "LastName is required.")
	private String lastName;

	@NotEmpty(message = "Bday is required.")
	private String bday;

	@NotEmpty(message = "Number of group is required.")
	private String groupId;



	//private Calendar created = Calendar.getInstance();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Calendar getCreated() {
//		return this.created;
//	}

//	public void setCreated(Calendar created) {
//		this.created = created;
//	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}
}
