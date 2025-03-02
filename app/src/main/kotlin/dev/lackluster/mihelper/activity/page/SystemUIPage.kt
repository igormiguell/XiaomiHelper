package dev.lackluster.mihelper.activity.page

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import dev.lackluster.hyperx.compose.activity.SafeSP
import dev.lackluster.hyperx.compose.base.BasePage
import dev.lackluster.hyperx.compose.base.BasePageDefaults
import dev.lackluster.hyperx.compose.navigation.navigateTo
import dev.lackluster.hyperx.compose.preference.DropDownEntry
import dev.lackluster.hyperx.compose.preference.DropDownPreference
import dev.lackluster.hyperx.compose.preference.PreferenceGroup
import dev.lackluster.hyperx.compose.preference.SeekBarPreference
import dev.lackluster.hyperx.compose.preference.SwitchPreference
import dev.lackluster.hyperx.compose.preference.TextPreference
import dev.lackluster.mihelper.R
import dev.lackluster.mihelper.activity.MainActivity
import dev.lackluster.mihelper.activity.component.RebootMenuItem
import dev.lackluster.mihelper.data.Pages
import dev.lackluster.mihelper.data.Pref
import dev.lackluster.mihelper.data.Scope

@Composable
fun SystemUIPage(navController: NavController, adjustPadding: PaddingValues, mode: BasePageDefaults.Mode) {
    val lockscreenCarrierLabelEntries = listOf(
        DropDownEntry(stringResource(R.string.systemui_lock_carrier_text_default)),
        DropDownEntry(stringResource(R.string.systemui_lock_carrier_text_carrier)),
        DropDownEntry(stringResource(R.string.systemui_lock_carrier_text_clock))
    )

    var visibilityCustomNotifCount by remember { mutableStateOf(
        SafeSP.getBoolean(Pref.Key.SystemUI.StatusBar.NOTIFICATION_COUNT)
    ) }

    BasePage(
        navController,
        adjustPadding,
        stringResource(R.string.page_systemui),
        MainActivity.blurEnabled,
        MainActivity.blurTintAlphaLight,
        MainActivity.blurTintAlphaDark,
        mode,
        actions = {
            RebootMenuItem(
                appName = stringResource(R.string.scope_systemui),
                appPkg = Scope.SYSTEM_UI
            )
        }
    ) {
        item {
            PreferenceGroup(
                stringResource(R.string.ui_title_systemui_status_bar),
                first = true
            ) {
                TextPreference(
                    title = stringResource(R.string.systemui_statusbar_clock)
                ) {
                    navController.navigateTo(Pages.STATUS_BAR_CLOCK)
                }
                SwitchPreference(
                    title = stringResource(R.string.systemui_statusbar_notif_count),
                    key = Pref.Key.SystemUI.StatusBar.NOTIFICATION_COUNT,
                    defValue = visibilityCustomNotifCount
                ) {
                    visibilityCustomNotifCount = it
                }
                AnimatedVisibility(
                    visibilityCustomNotifCount
                ) {
                    SeekBarPreference(
                        title = stringResource(R.string.systemui_statusbar_notif_count_icon),
                        key = Pref.Key.SystemUI.StatusBar.NOTIFICATION_COUNT_ICON,
                        defValue = 3,
                        min = 0,
                        max = 15
                    )
                }
                TextPreference(
                    title = stringResource(R.string.systemui_statusbar_font)
                ) {
                    navController.navigateTo(Pages.STATUS_BAR_FONT)
                }
                TextPreference(
                    title = stringResource(R.string.systemui_statusbar_icon)
                ) {
                    navController.navigateTo(Pages.ICON_TUNER)
                }
                SwitchPreference(
                    title = stringResource(R.string.systemui_statusbar_tap_to_sleep),
                    key = Pref.Key.SystemUI.StatusBar.DOUBLE_TAP_TO_SLEEP
                )
                SwitchPreference(
                    title = stringResource(R.string.systemui_statusbar_disable_smart_dark),
                    summary = stringResource(R.string.systemui_statusbar_disable_smart_dark_tips),
                    key = Pref.Key.SystemUI.StatusBar.DISABLE_SMART_DARK
                )
            }
        }
        item {
            PreferenceGroup(
                stringResource(R.string.ui_title_systemui_lock_screen)
            ) {
                SwitchPreference(
                    title = stringResource(R.string.systemui_lock_hide_disturb),
                    key = Pref.Key.SystemUI.LockScreen.HIDE_DISTURB
                )
                SwitchPreference(
                    title = stringResource(R.string.systemui_lock_double_tap),
                    key = Pref.Key.SystemUI.LockScreen.DOUBLE_TAP_TO_SLEEP
                )
                DropDownPreference(
                    title = stringResource(R.string.systemui_lock_carrier_text),
                    entries = lockscreenCarrierLabelEntries,
                    key = Pref.Key.SystemUI.LockScreen.CARRIER_TEXT
                )
            }
        }
        item {
            PreferenceGroup(
                title = stringResource(R.string.ui_title_systemui_notification_center)
            ) {
                SwitchPreference(
                    title = stringResource(R.string.systemui_notif_freeform),
                    summary = stringResource(R.string.systemui_notif_freeform_tips),
                    key = Pref.Key.SystemUI.NotifCenter.NOTIF_FREEFORM
                )
                SwitchPreference(
                    title = stringResource(R.string.systemui_notif_disable_whitelist),
                    key = Pref.Key.SystemUI.NotifCenter.NOTIF_NO_WHITELIST
                )
            }
        }
        item {
            PreferenceGroup(
                title = stringResource(R.string.ui_title_systemui_control_center)
            ) {
                SwitchPreference(
                    title = stringResource(R.string.systemui_control_hide_carrier_one),
                    key = Pref.Key.SystemUI.ControlCenter.HIDE_CARRIER_ONE
                )
                SwitchPreference(
                    title = stringResource(R.string.systemui_control_hide_carrier_two),
                    key = Pref.Key.SystemUI.ControlCenter.HIDE_CARRIER_TWO
                )
            }
        }
    }
}