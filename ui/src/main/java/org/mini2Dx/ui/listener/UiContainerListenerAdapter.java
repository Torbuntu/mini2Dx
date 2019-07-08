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
package org.mini2Dx.ui.listener;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.input.GamePadType;
import org.mini2Dx.ui.InputSource;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.element.UiElement;
import org.mini2Dx.ui.layout.ScreenSize;

/**
 * Adapter class that implements {@link UiContainerListener}. All methods are
 * no-op and can be overridden individually.
 */
public class UiContainerListenerAdapter implements UiContainerListener {

	@Override
	public void onScreenSizeChanged(ScreenSize screenSize) {
	}

	@Override
	public void preUpdate(UiContainer container, float delta) {
	}

	@Override
	public void postUpdate(UiContainer container, float delta) {
	}

	@Override
	public void preRender(UiContainer container, Graphics g) {
	}

	@Override
	public void postRender(UiContainer container, Graphics g) {
	}

	@Override
	public void inputSourceChanged(UiContainer container, InputSource oldInputSource, InputSource newInputSource) {
	}
	
	@Override
	public void gamePadTypeChanged(UiContainer container, GamePadType oldGamePadType,
	                               GamePadType newGamePadType) {
	}

	@Override
	public void onElementAction(UiContainer container, UiElement element) {
	}
}