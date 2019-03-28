"createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (
`action_history` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
`user_id` INTEGER NOT NULL,
`scenario_id` INTEGER NOT NULL,
`buttons_id` INTEGER NOT NULL,
`buttons_title` TEXT,
FOREIGN KEY(`user_id`
)"
"createSql": "CREATE  INDEX `index_ActionHistory_action_history` ON `${TABLE_NAME}` (
`action_history`
)"
 "createSql": "CREATE  INDEX `index_ActionHistory_user_id` ON `${TABLE_NAME}` (
 `user_id`
 )"
 "createSql": "CREATE  INDEX `index_ActionHistory_scenario_id` ON `${TABLE_NAME}` (
 `scenario_id`
 )"
 "createSql": "CREATE  INDEX `index_ActionHistory_buttons_id` ON `${TABLE_NAME}` (
 `buttons_id`
 )"
"createSql": "CREATE  INDEX `index_ActionHistory_buttons_title` ON `${TABLE_NAME}` (
`buttons_title`
)"
"createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (
`buttons_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
`from_scenario_id` INTEGER NOT NULL,
`to_scenario_id` INTEGER,
`title` TEXT,
FOREIGN KEY(`from_scenario_id`
)"
"createSql": "CREATE  INDEX `index_Button_from_scenario_id` ON `${TABLE_NAME}` (
`from_scenario_id`
)"
"createSql": "CREATE  INDEX `index_Button_to_scenario_id` ON `${TABLE_NAME}` (
`to_scenario_id`
)"
"createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (
`scenario_id` INTEGER NOT NULL,
`title` TEXT NOT NULL,
`resource_name` TEXT,
PRIMARY KEY(`scenario_id`)
)"
"createSql": "CREATE  INDEX `index_Scenario_scenario_id` ON `${TABLE_NAME}` (
`scenario_id`
)"
"createSql": "CREATE  INDEX `index_Scenario_title` ON `${TABLE_NAME}` (
`title`
)"
"createSql": "CREATE  INDEX `index_Scenario_resource_name` ON `${TABLE_NAME}` (
`resource_name`
)"
"createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (
`user_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
`name` TEXT
)"
"createSql": "CREATE  INDEX `index_User_user_id` ON `${TABLE_NAME}` (
`user_id`
)"
"createSql": "CREATE  INDEX `index_User_name` ON `${TABLE_NAME}` (
`name`
)"
