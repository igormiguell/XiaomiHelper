package dev.lackluster.mihelper.activity.pages.scope

import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import dev.lackluster.mihelper.R
import dev.lackluster.mihelper.data.PrefKey

@BMPage("scope_mi_connect", hideMenu = false)
class MiConnectPage : BasePage() {
    override fun getTitle(): String {
        return activity.getString(R.string.page_interconnection)
    }
    override fun onCreate() {
        TitleText(textId = R.string.scope_mi_share)
        TextSummaryWithSwitch(
            TextSummaryV(textId = R.string.interconnection_mishare_no_auto_off),
            SwitchV(PrefKey.MISHARE_NO_AUTO_OFF)
        )
        Line()
        TitleText(textId = R.string.ui_scope_mi_smart_hub)
        TextSummaryWithSwitch(
            TextSummaryV(textId = R.string.interconnection_mimirror_all_app),
            SwitchV(PrefKey.MISMARTHUB_ALL_APP)
        )
    }
}