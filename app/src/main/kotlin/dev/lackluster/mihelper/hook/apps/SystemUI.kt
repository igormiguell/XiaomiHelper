package dev.lackluster.mihelper.hook.apps

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import dev.lackluster.mihelper.hook.rules.shared.RemoveFreeformRestriction
import dev.lackluster.mihelper.hook.rules.systemui.DisableSmartDark
import dev.lackluster.mihelper.hook.rules.systemui.FuckStatusBarGestures
import dev.lackluster.mihelper.hook.rules.systemui.ResourcesUtils
import dev.lackluster.mihelper.hook.rules.systemui.StatusBarActions
import dev.lackluster.mihelper.hook.rules.systemui.lockscreen.BlockEditor
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.HideCarrierLabel
import dev.lackluster.mihelper.hook.rules.systemui.lockscreen.HideDisturbNotification
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.HideStatusBarIcon
import dev.lackluster.mihelper.hook.rules.systemui.lockscreen.HideUnlockTip
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.IconPosition
import dev.lackluster.mihelper.hook.rules.systemui.notif.NotifFreeform
import dev.lackluster.mihelper.hook.rules.systemui.notif.NotifSettingsRedirect
import dev.lackluster.mihelper.hook.rules.systemui.notif.NotifWhitelist
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.NotificationMaxNumber
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.StatusBarClock
import dev.lackluster.mihelper.hook.rules.systemui.freeform.HideTopBar
import dev.lackluster.mihelper.hook.rules.systemui.freeform.UnlockMultipleTask
import dev.lackluster.mihelper.hook.rules.systemui.lockscreen.CarrierText
import dev.lackluster.mihelper.hook.rules.systemui.lockscreen.DoubleTapToSleep
import dev.lackluster.mihelper.hook.rules.systemui.media.CustomElement
import dev.lackluster.mihelper.hook.rules.systemui.media.StyleCustomHookEntry
import dev.lackluster.mihelper.hook.rules.systemui.media.UnlockCustomAction
import dev.lackluster.mihelper.hook.rules.systemui.notif.AdvancedTextures
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.BatteryIndicator
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.HideCellularIcon
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.HideWiFiIcon
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.PadClockAnim
import dev.lackluster.mihelper.hook.rules.systemui.statusbar.StatusBarDoubleTapToSleep

object SystemUI : YukiBaseHooker() {
    override fun onHook() {
        loadHooker(ResourcesUtils)
        loadHooker(CarrierText)
        loadHooker(DoubleTapToSleep)
        loadHooker(HideDisturbNotification)

        loadHooker(NotifFreeform)
        loadHooker(NotifWhitelist)

        loadHooker(BatteryIndicator)
        loadHooker(HideCarrierLabel)
        loadHooker(HideCellularIcon)
        loadHooker(HideStatusBarIcon)
        loadHooker(HideWiFiIcon)
        loadHooker(IconPosition)
        loadHooker(StatusBarDoubleTapToSleep)

        loadHooker(DisableSmartDark)
        loadHooker(StatusBarActions)
        loadHooker(FuckStatusBarGestures)
        return
        loadHooker(RemoveFreeformRestriction)
        loadHooker(UnlockMultipleTask)
        loadHooker(HideTopBar)

        loadHooker(StatusBarClock)
        loadHooker(BlockEditor)

        loadHooker(HideUnlockTip)
        loadHooker(NotificationMaxNumber)

        loadHooker(NotifSettingsRedirect)

        loadHooker(AdvancedTextures)
        loadHooker(StyleCustomHookEntry)
        loadHooker(UnlockCustomAction)
        loadHooker(CustomElement)
        loadHooker(PadClockAnim)
    }
}