
import sys, os

__name__ = 'using_sys'
__version__ = '1.0'

print('Current Directory is:', os.getcwd())
print('The command line arguments are:')
for i in sys.argv:
    print(i)

print('\n\nThe PYTHONPATH is', sys.path, '\n')