import React from 'react';
import ReactDOM from 'react-dom';
import { mount } from 'enzyme';
import { MemoryRouter } from 'react-router';
import Logout from '.../Layout/NavigationBarAdminPage';
import App from './src/App'
import Adapter from 'enzyme-adapter-react-13';

configure({ adapter: new Adapter() });

test('valid path for worker page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/admin/login' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(Logout)).toHaveLength(1);
  });