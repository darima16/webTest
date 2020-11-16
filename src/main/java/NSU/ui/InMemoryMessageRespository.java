/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package NSU.ui;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

///**
// * @author Dave Syer
// */
//public class InMemoryMessageRespository implements MessageRepository {
//
//	private static AtomicLong counter = new AtomicLong();
//
//	private final ConcurrentMap<Long, Student> srudents = new ConcurrentHashMap<Long, Student>();
//
//	@Override
//	public Iterable<Student> findAll() {
//		return this.srudents.values();
//	}
//
//	@Override
//
//	public Student save(Student student) {
//		Long id = student.getId();
//		if (id == null) {
//			id = counter.incrementAndGet();
//			student.setId(id);
//		}
//		this.srudents.put(id, student);
//		return student;
//	}
//
//	@Override
//	public Student findMessage(Long id) {
//		return this.srudents.get(id);
//	}
//
//	@Override
//	public Iterable<Group> showGroups() { return null;
//
//	}
//
//
//
//}
