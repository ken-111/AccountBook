package com.example.accountbook.reference

class DefineConstName {
    companion object {
        /**  カレンダーページに遷移する数値*/
        const val CALENDAR_FRAGMENT = 1

        /**  トップページに遷移する数値*/
        const val TOP_FRAGMENT = 2

        /**  データページに遷移する数値*/
        const val GRAPH_FRAGMENT = 3

        /**  入力ページに遷移する数値*/
        const val INPUT_FRAGMENT = 4

        /**  日付ページに遷移する数値*/
        const val DATE_FRAGMENT = 5

        /**  データベースの*/
        const val ACCOUNT_TABLE = "account_table"

        /**  データベースの*/
        const val CATEGORY_TABLE = "category_table"

        /** DB名 */
        const val DB_NAME = "AccountDB"

        /** DBバージョン */
        const val DB_VERSION=1

        /** カテゴリー名　食費 */
        const val FOOD_CATEGORY = "食費"

        /** カテゴリー名　交通費 */
        const val RESIDENCE_CATEGORY = "住居/通信費"

        /** カテゴリー名　教育費 */
        const val EDUCATION_CATEGORY = "教育費"

        /** カテゴリー名　雑費 */
        const val DAILY_CATEGORY = "雑費"

        /** カテゴリー名　給与 */
        const val INCOME_CATEGORY = "給与"

        /** カテゴリー名　賞与 */
        const val  BONUS_CATEGORY = "賞与"
    }
}