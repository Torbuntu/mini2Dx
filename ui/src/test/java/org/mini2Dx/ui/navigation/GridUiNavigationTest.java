/*******************************************************************************
 * Copyright 2019 See AUTHORS file
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.mini2Dx.ui.navigation;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.mini2Dx.ui.element.Actionable;
import org.mini2Dx.ui.layout.ScreenSize;

import com.badlogic.gdx.Input.Keys;

import junit.framework.Assert;

/**
 * Unit tests for {@link GridUiNavigation}
 */
public class GridUiNavigationTest {
	private final int COLUMNS = 3;
	private final int ROWS = 3;
	
	private final Mockery mockery = new Mockery();
	private final GridUiNavigation navigation = new GridUiNavigation(COLUMNS);
	private final Actionable [][] elements = new Actionable[COLUMNS][ROWS];
	
	@Before
	public void setUp() {
		mockery.setImposteriser(ClassImposteriser.INSTANCE);
		
		for(int x = 0; x < COLUMNS; x++) {
			for(int y = 0; y < ROWS; y++) {
				elements[x][y] = mockery.mock(Actionable.class, "actionable-" + x + "," + y);

				final Actionable actionable = elements[x][y];
				mockery.checking(new Expectations() {
					{
						atLeast(1).of(actionable).addHoverListener(navigation);
						allowing(actionable).invokeEndHover();
					}
				});
			}
		}


	}
	
	@Test
	public void testSetXY() {
		addElementsToGrid();
		
		for(int x = 0; x < COLUMNS; x++) {
			for(int y = 0; y < ROWS; y++) {
				Assert.assertEquals(elements[x][y], navigation.get(x, y));
			}
		}
	}
	
	@Test
	public void testNavigate() {
		addElementsToGrid();
		
		Actionable lastActionable = null;
		for(int x = 0; x <= COLUMNS; x++) {
			lastActionable = navigation.navigate(Keys.RIGHT);
		}
		Assert.assertEquals(elements[2][0], lastActionable);
		
		for(int y = 0; y <= ROWS; y++) {
			lastActionable = navigation.navigate(Keys.DOWN);
		}
		Assert.assertEquals(elements[2][2], lastActionable);
		
		for(int x = 0; x <= COLUMNS; x++) {
			lastActionable = navigation.navigate(Keys.LEFT);
		}
		Assert.assertEquals(elements[0][2], lastActionable);
		
		for(int y = 0; y <= ROWS; y++) {
			lastActionable = navigation.navigate(Keys.UP);
		}
		Assert.assertEquals(elements[0][0], lastActionable);
	}
	
	@Test
	public void testCursorReset() {
		addElementsToGrid();
		
		Actionable lastActionable = null;
		for(int x = 0; x <= COLUMNS; x++) {
			lastActionable = navigation.navigate(Keys.RIGHT);
		}
		Assert.assertEquals(elements[2][0], lastActionable);
		
		navigation.layout(ScreenSize.XS);
		Assert.assertEquals(elements[2][0], navigation.getCursor());
	}
	
	private void addElementsToGrid() {
		for(int x = 0; x < COLUMNS; x++) {
			for(int y = 0; y < ROWS; y++) {
				navigation.set(x, y, elements[x][y]);
			}
		}
	}
}
