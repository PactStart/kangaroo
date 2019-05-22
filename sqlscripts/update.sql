ALTER TABLE `sys_version`
  ADD COLUMN `platform` VARCHAR(20) NOT NULL DEFAULT ''
COMMENT 'iOS平台appstore、enterprise'
  AFTER `version_owner`;