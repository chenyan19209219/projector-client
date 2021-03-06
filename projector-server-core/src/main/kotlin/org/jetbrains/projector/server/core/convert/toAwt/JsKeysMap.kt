/*
 * MIT License
 *
 * Copyright (c) 2019-2021 JetBrains s.r.o.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.jetbrains.projector.server.core.convert.toAwt

import org.jetbrains.projector.common.protocol.toServer.ClientKeyEvent
import java.awt.event.KeyEvent

internal fun Int.toJavaControlCharOrNull() = jControlCharMap[this]

internal fun String.toJavaCharOrNull(): Char? {
  singleOrNull()?.let { return it }

  return jsVisibleCharsMap[this]?.toChar()
}

internal fun String.toJavaCodeOrNull() = jsVisibleCharsMap[this] ?: jsCodeMap[this]

internal fun String.extractLocationOrNull() = jsCodeLocation[this]

private val jsCodeLocation = mapOf(
  "ControlLeft" to ClientKeyEvent.KeyLocation.LEFT,
  "MetaLeft" to ClientKeyEvent.KeyLocation.LEFT,
  "ShiftLeft" to ClientKeyEvent.KeyLocation.LEFT,
  "AltLeft" to ClientKeyEvent.KeyLocation.LEFT,
  "ControlRight" to ClientKeyEvent.KeyLocation.RIGHT,
  "MetaRight" to ClientKeyEvent.KeyLocation.RIGHT,
  "ShiftRight" to ClientKeyEvent.KeyLocation.RIGHT,
  "AltRight" to ClientKeyEvent.KeyLocation.RIGHT,
)

// todo: transfer more events here
private val jsVisibleCharsMap = mapOf(
  "Tab" to KeyEvent.VK_TAB,
  "Enter" to KeyEvent.VK_ENTER,
  "Backspace" to KeyEvent.VK_BACK_SPACE,
)

private val jsCodeMap = mapOf(
  "" to KeyEvent.VK_UNDEFINED,
  "Unidentified" to KeyEvent.VK_UNDEFINED,
  "Escape" to KeyEvent.VK_ESCAPE,
  "Digit1" to KeyEvent.VK_1,
  "Digit2" to KeyEvent.VK_2,
  "Digit3" to KeyEvent.VK_3,
  "Digit4" to KeyEvent.VK_4,
  "Digit5" to KeyEvent.VK_5,
  "Digit6" to KeyEvent.VK_6,
  "Digit7" to KeyEvent.VK_7,
  "Digit8" to KeyEvent.VK_8,
  "Digit9" to KeyEvent.VK_9,
  "Digit0" to KeyEvent.VK_0,
  "Minus" to KeyEvent.VK_MINUS,
  "Equal" to KeyEvent.VK_EQUALS,
  "KeyQ" to KeyEvent.VK_Q,
  "KeyW" to KeyEvent.VK_W,
  "KeyE" to KeyEvent.VK_E,
  "KeyR" to KeyEvent.VK_R,
  "KeyT" to KeyEvent.VK_T,
  "KeyY" to KeyEvent.VK_Y,
  "KeyU" to KeyEvent.VK_U,
  "KeyI" to KeyEvent.VK_I,
  "KeyO" to KeyEvent.VK_O,
  "KeyP" to KeyEvent.VK_P,
  "BracketLeft" to KeyEvent.VK_OPEN_BRACKET,
  "BracketRight" to KeyEvent.VK_CLOSE_BRACKET,
  "ControlLeft" to KeyEvent.VK_CONTROL,
  "Control" to KeyEvent.VK_CONTROL,
  "Meta" to KeyEvent.VK_META,
  "MetaLeft" to KeyEvent.VK_META,
  "MetaRight" to KeyEvent.VK_META,
  "KeyA" to KeyEvent.VK_A,
  "KeyS" to KeyEvent.VK_S,
  "KeyD" to KeyEvent.VK_D,
  "KeyF" to KeyEvent.VK_F,
  "KeyG" to KeyEvent.VK_G,
  "KeyH" to KeyEvent.VK_H,
  "KeyJ" to KeyEvent.VK_J,
  "KeyK" to KeyEvent.VK_K,
  "KeyL" to KeyEvent.VK_L,
  "Semicolon" to KeyEvent.VK_SEMICOLON,
  "Quote" to KeyEvent.VK_QUOTE,
  "Backquote" to KeyEvent.VK_BACK_QUOTE,
  "ShiftLeft" to KeyEvent.VK_SHIFT,
  "Shift" to KeyEvent.VK_SHIFT,
  "Backslash" to KeyEvent.VK_BACK_SLASH,
  "KeyZ" to KeyEvent.VK_Z,
  "KeyX" to KeyEvent.VK_X,
  "KeyC" to KeyEvent.VK_C,
  "KeyV" to KeyEvent.VK_V,
  "KeyB" to KeyEvent.VK_B,
  "KeyN" to KeyEvent.VK_N,
  "KeyM" to KeyEvent.VK_M,
  "Comma" to KeyEvent.VK_COMMA,
  "Period" to KeyEvent.VK_PERIOD,
  "Slash" to KeyEvent.VK_SLASH,
  "ShiftRight" to KeyEvent.VK_SHIFT,
  "NumpadMultiply" to KeyEvent.VK_MULTIPLY,
  "AltLeft" to KeyEvent.VK_ALT,
  "Alt" to KeyEvent.VK_ALT,
  "Space" to KeyEvent.VK_SPACE,
  "CapsLock" to KeyEvent.VK_CAPS_LOCK,
  "F1" to KeyEvent.VK_F1,
  "F2" to KeyEvent.VK_F2,
  "F3" to KeyEvent.VK_F3,
  "F4" to KeyEvent.VK_F4,
  "F5" to KeyEvent.VK_F5,
  "F6" to KeyEvent.VK_F6,
  "F7" to KeyEvent.VK_F7,
  "F8" to KeyEvent.VK_F8,
  "F9" to KeyEvent.VK_F9,
  "F10" to KeyEvent.VK_F10,
  "NumLock" to KeyEvent.VK_NUM_LOCK,
  "ScrollLock" to KeyEvent.VK_SCROLL_LOCK,
  "Numpad7" to KeyEvent.VK_NUMPAD7,
  "Numpad8" to KeyEvent.VK_NUMPAD8,
  "Numpad9" to KeyEvent.VK_NUMPAD9,
  "NumpadSubtract" to KeyEvent.VK_SUBTRACT,
  "Numpad4" to KeyEvent.VK_NUMPAD4,
  "Numpad5" to KeyEvent.VK_NUMPAD5,
  "Numpad6" to KeyEvent.VK_NUMPAD6,
  "NumpadAdd" to KeyEvent.VK_ADD,
  "Numpad1" to KeyEvent.VK_NUMPAD1,
  "Numpad2" to KeyEvent.VK_NUMPAD2,
  "Numpad3" to KeyEvent.VK_NUMPAD3,
  "Numpad0" to KeyEvent.VK_NUMPAD0,
  "NumpadDecimal" to KeyEvent.VK_DECIMAL,
  "IntlBackslash" to KeyEvent.VK_BACK_SLASH,  // Java does not have this
  "F11" to KeyEvent.VK_F11,
  "F12" to KeyEvent.VK_F12,
  //"IntlRo" to KeyEvent.VK_,  // Java does not have this
  "Convert" to KeyEvent.VK_CONVERT,
  "KanaMode" to KeyEvent.VK_KANA,
  "NonConvert" to KeyEvent.VK_NONCONVERT,
  "NumpadEnter" to KeyEvent.VK_ENTER,  // Java does not have this
  "ControlRight" to KeyEvent.VK_CONTROL,
  "NumpadDivide" to KeyEvent.VK_DIVIDE,
  "PrintScreen" to KeyEvent.VK_PRINTSCREEN,
  "AltRight" to KeyEvent.VK_ALT,
  "Home" to KeyEvent.VK_HOME,
  "ArrowUp" to KeyEvent.VK_UP,
  "PageUp" to KeyEvent.VK_PAGE_UP,
  "ArrowLeft" to KeyEvent.VK_LEFT,
  "ArrowRight" to KeyEvent.VK_RIGHT,
  "End" to KeyEvent.VK_END,
  "ArrowDown" to KeyEvent.VK_DOWN,
  "PageDown" to KeyEvent.VK_PAGE_DOWN,
  "Insert" to KeyEvent.VK_INSERT,
  "Delete" to KeyEvent.VK_DELETE,
  //"AudioVolumeMute" to KeyEvent.VK_,  // Java does not have this
  //"VolumeMute" to KeyEvent.VK_,  // Java does not have this
  //"AudioVolumeDown" to KeyEvent.VK_,  // Java does not have this
  //"VolumeDown" to KeyEvent.VK_,  // Java does not have this
  //"AudioVolumeUp" to KeyEvent.VK_,  // Java does not have this
  //"VolumeUp" to KeyEvent.VK_,  // Java does not have this
  //"Power" to KeyEvent.VK_,  // Java does not have this
  "NumpadEqual" to KeyEvent.VK_EQUALS,  // Java does not have this
  //"NumpadChangeSign" to KeyEvent.VK_,  // Java does not have this
  "Pause" to KeyEvent.VK_PAUSE,
  "NumpadComma" to KeyEvent.VK_COMMA,  // Java does not have this
  //"Lang1" to KeyEvent.VK_,  // Java does not have this
  //"HangulMode" to KeyEvent.VK_,  // Java does not have this
  //"Lang2" to KeyEvent.VK_,  // Java does not have this
  //"Hanja" to KeyEvent.VK_,  // Java does not have this
  //"IntlYen" to KeyEvent.VK_,  // Java does not have this
  //"OSLeft" to KeyEvent.VK_,  // Java does not have this
  //"OSRight" to KeyEvent.VK_,  // Java does not have this
  "ContextMenu" to KeyEvent.VK_CONTEXT_MENU,
  //"BrowserStop" to KeyEvent.VK_,  // Java does not have this
  "Cancel" to KeyEvent.VK_CANCEL,
  "Again" to KeyEvent.VK_AGAIN,
  "Props" to KeyEvent.VK_PROPS,
  "Undo" to KeyEvent.VK_UNDO,
  //"Select" to KeyEvent.VK_,  // Java does not have this
  "Copy" to KeyEvent.VK_COPY,
  //"Open" to KeyEvent.VK_,  // Java does not have this
  "Paste" to KeyEvent.VK_PASTE,
  "Find" to KeyEvent.VK_FIND,
  "Cut" to KeyEvent.VK_CUT,
  "Help" to KeyEvent.VK_HELP,
  //"LaunchApp2" to KeyEvent.VK_,  // Java does not have this
  //"WakeUp" to KeyEvent.VK_,  // Java does not have this
  //"LaunchApp1" to KeyEvent.VK_,  // Java does not have this
  //"LaunchMail" to KeyEvent.VK_,  // Java does not have this
  //"BrowserFavorites" to KeyEvent.VK_,  // Java does not have this
  //"BrowserBack" to KeyEvent.VK_,  // Java does not have this
  //"BrowserForward" to KeyEvent.VK_,  // Java does not have this
  //"Eject" to KeyEvent.VK_,  // Java does not have this
  //"MediaTrackNext" to KeyEvent.VK_,  // Java does not have this
  //"MediaPlayPause" to KeyEvent.VK_,  // Java does not have this
  //"MediaTrackPrevious" to KeyEvent.VK_,  // Java does not have this
  //"MediaStop" to KeyEvent.VK_,  // Java does not have this
  //"LaunchMediaPlayer" to KeyEvent.VK_,  // Java does not have this
  //"BrowserHome" to KeyEvent.VK_,  // Java does not have this
  //"BrowserRefresh" to KeyEvent.VK_,  // Java does not have this
  "NumpadParenLeft" to KeyEvent.VK_LEFT_PARENTHESIS,
  "NumpadParenRight" to KeyEvent.VK_RIGHT_PARENTHESIS,
  "F13" to KeyEvent.VK_F13,
  "F14" to KeyEvent.VK_F14,
  "F15" to KeyEvent.VK_F15,
  "F16" to KeyEvent.VK_F16,
  "F17" to KeyEvent.VK_F17,
  "F18" to KeyEvent.VK_F18,
  "F19" to KeyEvent.VK_F19,
  "F20" to KeyEvent.VK_F20,
  "F21" to KeyEvent.VK_F21,
  "F22" to KeyEvent.VK_F22,
  "F23" to KeyEvent.VK_F23,
  "F24" to KeyEvent.VK_F24,
  //"BrowserSearch" to KeyEvent.VK_,  // Java does not have this
)

// Maps symbol to control character when Ctrl is pressed
// The right part is the subset of ASCII control characters:
// https://en.wikipedia.org/wiki/Control_character
// This map was generated by logging key events in headfull mode.
private val jControlCharMap = mapOf(
  KeyEvent.VK_A to '\u0001',
  KeyEvent.VK_B to '\u0002',
  KeyEvent.VK_C to '\u0003',
  KeyEvent.VK_D to '\u0004',
  KeyEvent.VK_E to '\u0005',
  KeyEvent.VK_F to '\u0006',
  KeyEvent.VK_G to '\u0007',
  KeyEvent.VK_H to '\u0008',
  KeyEvent.VK_I to '\u0009',
  KeyEvent.VK_J to '\u000a',
  KeyEvent.VK_K to '\u000b',
  KeyEvent.VK_L to '\u000c',
  KeyEvent.VK_M to '\u000d',
  KeyEvent.VK_N to '\u000e',
  KeyEvent.VK_O to '\u000f',
  KeyEvent.VK_P to '\u0010',
  KeyEvent.VK_Q to '\u0011',
  KeyEvent.VK_R to '\u0012',
  KeyEvent.VK_S to '\u0013',
  KeyEvent.VK_T to '\u0014',
  KeyEvent.VK_U to '\u0015',
  KeyEvent.VK_V to '\u0016',
  KeyEvent.VK_W to '\u0017',
  KeyEvent.VK_X to '\u0018',
  KeyEvent.VK_Y to '\u0019',
  KeyEvent.VK_Z to '\u001a',
  KeyEvent.VK_OPEN_BRACKET to '\u001b',
  KeyEvent.VK_BACK_SLASH to '\u001c',
  KeyEvent.VK_CLOSE_BRACKET to '\u001d',
)
