import os
import time

source_dir = ['/Users/gavin/workspaces/my']
target_dir =  '/Users/gavin/workbackup'

target_file = target_dir + os.sep + \
    time.strftime('%Y%m%d%H%M%S') + '.zip'

if not os.path.exists(target_dir):
    os.mkdir(target_dir)

zip_command = 'zip -r {0} {1}'.format(target_file, ''.join(source_dir))
print('Zip command is:' + zip_command)
print('Running:')

if os.system(zip_command) == 0:
    print('Successful backup to', target_file)
else:
    print('Backup Failed.')