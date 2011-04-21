/* 
 * Mutability Detector
 *
 * Copyright 2009 Graham Allan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.mutabilitydetector.benchmarks.inheritance;


import static org.mutabilitydetector.ImmutableAssert.assertDefinitelyNotImmutable;
import static org.mutabilitydetector.ImmutableAssert.assertImmutable;
import static org.mutabilitydetector.TestUtil.getAnalysisResult;
import static org.mutabilitydetector.TestUtil.getIsImmutableResult;

import org.junit.Ignore;
import org.junit.Test;
import org.mutabilitydetector.benchmarks.types.EnumType;


public class TestSubclassingOfImmutableType {

	@Test public void testSupertypeIsDefinitelyNotImmutable() throws Exception {
		assertDefinitelyNotImmutable(getAnalysisResult(MutableSupertype.class));
	}
	
	@Ignore("InheritedMutabilityChecker doesn't work properly yet.")
	@Test public void testImmutableSubtypeIsReportedAsImmutable() throws Exception {
		assertDefinitelyNotImmutable(getIsImmutableResult(ImmutableSubtypeOfMutableSupertype.class));
	}
	
	@Test public void testMutableSubtype() throws Exception {
		assertDefinitelyNotImmutable(getIsImmutableResult(MutableSubtypeOfMutableSupertype.class));
	}
	
	@Test public void testEnumTypeIsDefinitelyImmutable() throws Exception {
		assertImmutable(getAnalysisResult(EnumType.class));
	}
}